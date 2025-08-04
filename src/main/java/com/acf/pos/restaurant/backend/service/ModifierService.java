package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.common.Logger;
import com.acf.pos.restaurant.backend.common.LoggerFactory;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.dto.ModifierCreateRequest;
import com.acf.pos.restaurant.backend.dto.ModifierUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Modifier;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;
import com.acf.pos.restaurant.backend.exception.ResourceNotFoundException;
import com.acf.pos.restaurant.backend.exception.ValidationException;
import com.acf.pos.restaurant.backend.mapper.ModifierMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ModifierService {

    private static final Logger log = LoggerFactory.getLogger(ModifierService.class);

    private final Dao<Modifier, String> modifierDao;
    private final Dao<ModifierGroup, String> modifierGroupDao;
    private final ModifierMapper modifierMapper;
    private final TransactionManager transactionManager;

    public ModifierService(
            Dao<Modifier, String> modifierDao,
            Dao<ModifierGroup, String> modifierGroupDao,
            ModifierMapper modifierMapper,
            TransactionManager transactionManager) {
        this.modifierDao = modifierDao;
        this.modifierGroupDao = modifierGroupDao;
        this.modifierMapper = modifierMapper;
        this.transactionManager = transactionManager;
    }

    public Modifier createModifier(ModifierCreateRequest request) throws SQLException {
        log.info("Creating modifier with name: %s for modifier group: %s", request.getName(), request.getModifierGroupId());
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            ModifierGroup modifierGroup = modifierGroupDao.queryForId(request.getModifierGroupId());
            if (modifierGroup == null) {
                log.warn("Modifier group not found with ID: %s", request.getModifierGroupId());
                throw new ResourceNotFoundException("ModifierGroup", request.getModifierGroupId());
            }
            
            Modifier modifier = modifierMapper.toEntity(request);
            modifier.setModifierGroup(modifierGroup);
            
            Date now = new Date();
            modifier.setCreatedAt(now);
            modifier.setUpdatedAt(now);
            modifier.setDirty(true);
            
            modifierDao.create(modifier);
            
            log.info("Successfully created modifier with ID: %s", modifier.getId());
            return modifier;
        });
    }

    public Modifier updateModifier(String modifierId, ModifierUpdateRequest request) throws SQLException {
        log.info("Updating modifier with ID: %s", modifierId);
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            Modifier existingModifier = modifierDao.queryForId(modifierId);
            if (existingModifier == null) {
                log.warn("Modifier not found with ID: %s", modifierId);
                throw new ResourceNotFoundException("Modifier", modifierId);
            }
            
            modifierMapper.updateEntity(existingModifier, request);
            
            existingModifier.setUpdatedAt(new Date());
            existingModifier.setDirty(true);
            
            modifierDao.update(existingModifier);
            
            log.info("Successfully updated modifier with ID: %s", modifierId);
            return existingModifier;
        });
    }

    public Modifier getModifierById(String id) throws SQLException {
        log.debug("Retrieving modifier with ID: %s", id);
        
        Modifier modifier = modifierDao.queryForId(id);
        if (modifier == null) {
            log.warn("Modifier not found with ID: %s", id);
            throw new ResourceNotFoundException("Modifier", id);
        }
        return modifier;
    }

    public List<Modifier> getAllModifiersByGroup(String modifierGroupId) throws SQLException {
        QueryBuilder<Modifier, String> queryBuilder = modifierDao.queryBuilder();
        queryBuilder.where()
                .eq("modifier_group_id", modifierGroupId)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Modifier> getActiveModifiersByGroup(String modifierGroupId) throws SQLException {
        QueryBuilder<Modifier, String> queryBuilder = modifierDao.queryBuilder();
        queryBuilder.where()
                .eq("modifier_group_id", modifierGroupId)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Modifier> getDefaultModifiersByGroup(String modifierGroupId) throws SQLException {
        QueryBuilder<Modifier, String> queryBuilder = modifierDao.queryBuilder();
        queryBuilder.where()
                .eq("modifier_group_id", modifierGroupId)
                .and()
                .eq("is_default", true)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Modifier> getFreeModifiersByGroup(String modifierGroupId) throws SQLException {
        QueryBuilder<Modifier, String> queryBuilder = modifierDao.queryBuilder();
        queryBuilder.where()
                .eq("modifier_group_id", modifierGroupId)
                .and()
                .eq("price", 0.0)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public boolean deleteModifier(String id) throws SQLException {
        Modifier modifier = modifierDao.queryForId(id);
        if (modifier != null) {
            modifier.setDeleted(true);
            modifier.setUpdatedAt(new Date());
            modifier.setDirty(true);
            modifierDao.update(modifier);
            return true;
        }
        return false;
    }

    public boolean toggleModifierStatus(String id) throws SQLException {
        Modifier modifier = modifierDao.queryForId(id);
        if (modifier != null) {
            modifier.setIsActive(!modifier.getIsActive());
            modifier.setUpdatedAt(new Date());
            modifier.setDirty(true);
            modifierDao.update(modifier);
            return true;
        }
        return false;
    }

    public boolean toggleDefaultStatus(String id) throws SQLException {
        Modifier modifier = modifierDao.queryForId(id);
        if (modifier != null) {
            modifier.setIsDefault(!modifier.getIsDefault());
            modifier.setUpdatedAt(new Date());
            modifier.setDirty(true);
            modifierDao.update(modifier);
            return true;
        }
        return false;
    }

    public boolean updateDisplayOrder(String id, Integer newOrder) throws SQLException {
        Modifier modifier = modifierDao.queryForId(id);
        if (modifier != null) {
            modifier.setDisplayOrder(newOrder);
            modifier.setUpdatedAt(new Date());
            modifier.setDirty(true);
            modifierDao.update(modifier);
            return true;
        }
        return false;
    }

    public boolean updatePrice(String id, Double newPrice) throws SQLException {
        Modifier modifier = modifierDao.queryForId(id);
        if (modifier != null && newPrice >= 0) {
            modifier.setPrice(newPrice);
            modifier.setUpdatedAt(new Date());
            modifier.setDirty(true);
            modifierDao.update(modifier);
            return true;
        }
        return false;
    }

    public long getModifierCount(String modifierGroupId) throws SQLException {
        QueryBuilder<Modifier, String> queryBuilder = modifierDao.queryBuilder();
        queryBuilder.where()
                .eq("modifier_group_id", modifierGroupId)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getActiveModifierCount(String modifierGroupId) throws SQLException {
        QueryBuilder<Modifier, String> queryBuilder = modifierDao.queryBuilder();
        queryBuilder.where()
                .eq("modifier_group_id", modifierGroupId)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }
}