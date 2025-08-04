package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.common.Logger;
import com.acf.pos.restaurant.backend.common.LoggerFactory;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.dto.PrefixCreateRequest;
import com.acf.pos.restaurant.backend.dto.PrefixUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Prefix;
import com.acf.pos.restaurant.backend.exception.ResourceNotFoundException;
import com.acf.pos.restaurant.backend.exception.ValidationException;
import com.acf.pos.restaurant.backend.mapper.PrefixMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PrefixService {

    private static final Logger log = LoggerFactory.getLogger(PrefixService.class);

    private final Dao<Prefix, String> prefixDao;
    private final PrefixMapper prefixMapper;
    private final TransactionManager transactionManager;

    public PrefixService(
            Dao<Prefix, String> prefixDao,
            PrefixMapper prefixMapper,
            TransactionManager transactionManager) {
        this.prefixDao = prefixDao;
        this.prefixMapper = prefixMapper;
        this.transactionManager = transactionManager;
    }

    public Prefix createPrefix(PrefixCreateRequest request) throws SQLException {
        log.info("Creating prefix with name: %s", request.getName());
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            Prefix prefix = prefixMapper.toEntity(request);
            
            Date now = new Date();
            prefix.setCreatedAt(now);
            prefix.setUpdatedAt(now);
            prefix.setDirty(true);
            
            prefixDao.create(prefix);
            
            log.info("Successfully created prefix with ID: %s", prefix.getId());
            return prefix;
        });
    }

    public Prefix updatePrefix(String prefixId, PrefixUpdateRequest request) throws SQLException {
        log.info("Updating prefix with ID: %s", prefixId);
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            Prefix existingPrefix = prefixDao.queryForId(prefixId);
            if (existingPrefix == null) {
                log.warn("Prefix not found with ID: %s", prefixId);
                throw new ResourceNotFoundException("Prefix", prefixId);
            }
            
            prefixMapper.updateEntity(existingPrefix, request);
            
            existingPrefix.setUpdatedAt(new Date());
            existingPrefix.setDirty(true);
            
            prefixDao.update(existingPrefix);
            
            log.info("Successfully updated prefix with ID: %s", prefixId);
            return existingPrefix;
        });
    }

    public Prefix getPrefixById(String id) throws SQLException {
        log.debug("Retrieving prefix with ID: %s", id);
        
        Prefix prefix = prefixDao.queryForId(id);
        if (prefix == null) {
            log.warn("Prefix not found with ID: %s", id);
            throw new ResourceNotFoundException("Prefix", id);
        }
        return prefix;
    }

    public List<Prefix> getAllPrefixes() throws SQLException {
        QueryBuilder<Prefix, String> queryBuilder = prefixDao.queryBuilder();
        queryBuilder.where().eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Prefix> getActivePrefixes() throws SQLException {
        QueryBuilder<Prefix, String> queryBuilder = prefixDao.queryBuilder();
        queryBuilder.where()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public boolean deletePrefix(String id) throws SQLException {
        Prefix prefix = prefixDao.queryForId(id);
        if (prefix != null) {
            prefix.setDeleted(true);
            prefix.setUpdatedAt(new Date());
            prefix.setDirty(true);
            prefixDao.update(prefix);
            return true;
        }
        return false;
    }

    public boolean updateDisplayOrder(String id, Integer newOrder) throws SQLException {
        Prefix prefix = prefixDao.queryForId(id);
        if (prefix != null) {
            prefix.setDisplayOrder(newOrder);
            prefix.setUpdatedAt(new Date());
            prefix.setDirty(true);
            prefixDao.update(prefix);
            return true;
        }
        return false;
    }

    public long getPrefixCount() throws SQLException {
        QueryBuilder<Prefix, String> queryBuilder = prefixDao.queryBuilder();
        queryBuilder.where().eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getActivePrefixCount() throws SQLException {
        QueryBuilder<Prefix, String> queryBuilder = prefixDao.queryBuilder();
        queryBuilder.where()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }
}