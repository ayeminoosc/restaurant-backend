package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.entity.RefreshToken;
import com.acf.pos.restaurant.backend.pojo.RotatedTokenResponse;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Autowired
    Dao<RefreshToken, String> refreshTokenDao;

    @Autowired
    TransactionManager transactionManager;

    @Value("${jwt.refresh.expiration.days:7}")
    private long expirationTimeInDays;

    private Logger logger = LogManager.getLogger(RefreshTokenService.class);

    public String create(String subject) throws SQLException {
        return transactionManager.callInTransaction(() -> {
            String token = UUID.randomUUID().toString();
            RefreshToken rt = new RefreshToken();
            rt.setId(token);
            rt.setUserId(subject);
            rt.setCreatedAt(new Date());
            rt.setExpiresAt(new Date(System.currentTimeMillis() + expirationTimeInDays * 24 * 60 * 60 * 1000));
            rt.setRevoked(false);
            refreshTokenDao.create(rt);
            return token;
        });
    }

    public String verify(String token) throws SQLException {
        return transactionManager.callInTransaction(() -> {
            RefreshToken rt = refreshTokenDao.queryForId(token);
            if (rt == null || rt.isRevoked() || rt.getExpiresAt().before(new Date())) {
                throw new RuntimeException("Invalid or expired refresh token");
            }
            return rt.getUserId();
        });
    }

    public RotatedTokenResponse verifyAndRotate(String oldToken) throws SQLException {
        RefreshToken oldRt = refreshTokenDao.queryForId(oldToken);

        if (oldRt == null) {
            logger.error("Refresh token not found: {}", oldToken);
            throw new RuntimeException("Invalid refresh token");
        }

        // --- CRITICAL CHANGE: Prioritize compromise detection ---
        if (oldRt.isRevoked()) {
            // This token was already revoked, but is being used again.
            // This is a strong signal of compromise. Invalidate all tokens for this user.
            DeleteBuilder<RefreshToken, String> deleteBuilder = refreshTokenDao.deleteBuilder();
            deleteBuilder.where().eq("user_id", oldRt.getUserId());
            deleteBuilder.delete(); // Execute cascading invalidation
            logger.error("Compromised refresh token detected for user: {}. All related tokens revoked.", oldRt.getUserId());
            throw new RuntimeException("Compromised refresh token. All related tokens revoked.");
        }

        // --- Normal expiration check (only if not already revoked) ---
        if (oldRt.getExpiresAt().before(new Date())) {
            // Token is expired, but not revoked (normal expiration). Clean it up.
            refreshTokenDao.delete(oldRt);
            logger.error("Refresh token expired for user: {}", oldRt.getUserId());
            throw new RuntimeException("Refresh token has expired");
        }

        return transactionManager.callInTransaction(() -> {
            // Revoke the old token
            oldRt.setRevoked(true);
            refreshTokenDao.update(oldRt);

            // Create a new refresh token
            String newRefreshTokenString = UUID.randomUUID().toString();
            RefreshToken newRt = new RefreshToken();
            newRt.setId(newRefreshTokenString);
            newRt.setUserId(oldRt.getUserId());
            newRt.setCreatedAt(new Date());
            newRt.setExpiresAt(new Date(System.currentTimeMillis() + expirationTimeInDays * 24 * 60 * 60 * 1000));
            newRt.setRevoked(false);
            refreshTokenDao.create(newRt);

            return new RotatedTokenResponse(oldRt.getUserId(), newRefreshTokenString);
        });
    }

    public void revoke(String token) throws SQLException {
        transactionManager.callInTransaction(() -> {
            RefreshToken rt = refreshTokenDao.queryForId(token);
            if (rt != null) {
                rt.setRevoked(true);
                refreshTokenDao.update(rt);
            }
            return null;
        });
    }
}
