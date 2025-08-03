package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.entity.RefreshToken;
import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
@Service
public class RefreshTokenService {
    @Autowired
    Dao<RefreshToken, String> refreshTokenDao;

    public String create(String userId) throws SQLException {
        String token = UUID.randomUUID().toString();
        RefreshToken rt = new RefreshToken();
        rt.setId(token);
        rt.setUserId(userId);
        rt.setCreatedAt(new Date());
        rt.setExpiresAt(new Date(System.currentTimeMillis() + 7L * 86400000)); // 7 days
        rt.setRevoked(false);
        refreshTokenDao.create(rt);
        return token;
    }

    public String verify(String token) throws SQLException {
        RefreshToken rt = refreshTokenDao.queryForId(token);
        if (rt == null || rt.isRevoked() || rt.getExpiresAt().before(new Date())) {
            throw new RuntimeException("Invalid or expired refresh token");
        }
        return rt.getUserId();
    }

    public void revoke(String token) throws SQLException {
        RefreshToken rt = refreshTokenDao.queryForId(token);
        if (rt != null) {
            rt.setRevoked(true);
            refreshTokenDao.update(rt);
        }
    }
}
