package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.common.Logger;
import com.acf.pos.restaurant.backend.common.LoggerFactory;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.dto.ModifierGroupCreateRequest;
import com.acf.pos.restaurant.backend.dto.ModifierGroupUpdateRequest;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;
import com.acf.pos.restaurant.backend.exception.ResourceNotFoundException;
import com.acf.pos.restaurant.backend.exception.ValidationException;
import com.acf.pos.restaurant.backend.mapper.ModifierGroupMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ModifierGroupService {

    private static final Logger log = LoggerFactory.getLogger(ModifierGroupService.class);

    private final Dao<ModifierGroup, String> modifierGroupDao;
    private final ModifierGroupMapper modifierGroupMapper;
    private final TransactionManager transactionManager;

    public ModifierGroupService(
            Dao<ModifierGroup, String> modifierGroupDao,
            ModifierGroupMapper modifierGroupMapper,
            TransactionManager transactionManager) {
        this.modifierGroupDao = modifierGroupDao;
        this.modifierGroupMapper = modifierGroupMapper;
        this.transactionManager = transactionManager;
    }

    public ModifierGroup createModifierGroup(ModifierGroupCreateRequest request) throws SQLException {
        log.info("Creating modifier group with name: %s", request.getName());
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            ModifierGroup modifierGroup = modifierGroupMapper.toEntity(request);
            
            Date now = new Date();
            modifierGroup.setCreatedAt(now);
            modifierGroup.setUpdatedAt(now);
            modifierGroup.setDirty(true);
            
            modifierGroupDao.create(modifierGroup);
            
            log.info("Successfully created modifier group with ID: %s", modifierGroup.getId());
            return modifierGroup;
        });
    }

    public ModifierGroup updateModifierGroup(String modifierGroupId, ModifierGroupUpdateRequest request) throws SQLException {
        log.info("Updating modifier group with ID: %s", modifierGroupId);
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            ModifierGroup existingModifierGroup = modifierGroupDao.queryForId(modifierGroupId);
            if (existingModifierGroup == null) {
                log.warn("Modifier group not found with ID: %s", modifierGroupId);
                throw new ResourceNotFoundException("ModifierGroup", modifierGroupId);
            }
            
            modifierGroupMapper.updateEntity(existingModifierGroup, request);
            
            existingModifierGroup.setUpdatedAt(new Date());
            existingModifierGroup.setDirty(true);
            
            modifierGroupDao.update(existingModifierGroup);
            
            log.info("Successfully updated modifier group with ID: %s", modifierGroupId);
            return existingModifierGroup;
        });
    }

    public ModifierGroup getModifierGroupById(String id) throws SQLException {
        log.debug("Retrieving modifier group with ID: %s", id);
        
        ModifierGroup modifierGroup = modifierGroupDao.queryForId(id);
        if (modifierGroup == null) {
            log.warn("Modifier group not found with ID: %s", id);
            throw new ResourceNotFoundException("ModifierGroup", id);
        }
        return modifierGroup;
    }

    public List<ModifierGroup> getAllModifierGroups() throws SQLException {
        QueryBuilder<ModifierGroup, String> queryBuilder = modifierGroupDao.queryBuilder();
        queryBuilder.where().eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<ModifierGroup> getActiveModifierGroups() throws SQLException {
        QueryBuilder<ModifierGroup, String> queryBuilder = modifierGroupDao.queryBuilder();
        queryBuilder.where()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<ModifierGroup> getRequiredModifierGroups() throws SQLException {
        QueryBuilder<ModifierGroup, String> queryBuilder = modifierGroupDao.queryBuilder();
        queryBuilder.where()
                .eq("required", true)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public boolean deleteModifierGroup(String id) throws SQLException {
        ModifierGroup modifierGroup = modifierGroupDao.queryForId(id);
        if (modifierGroup != null) {
            modifierGroup.setDeleted(true);
            modifierGroup.setUpdatedAt(new Date());
            modifierGroup.setDirty(true);
            modifierGroupDao.update(modifierGroup);
            return true;
        }
        return false;
    }

    public boolean toggleModifierGroupStatus(String id) throws SQLException {
        ModifierGroup modifierGroup = modifierGroupDao.queryForId(id);
        if (modifierGroup != null) {
            modifierGroup.setIsActive(!modifierGroup.getIsActive());
            modifierGroup.setUpdatedAt(new Date());
            modifierGroup.setDirty(true);
            modifierGroupDao.update(modifierGroup);
            return true;
        }
        return false;
    }

    public boolean updateDisplayOrder(String id, Integer newOrder) throws SQLException {
        ModifierGroup modifierGroup = modifierGroupDao.queryForId(id);
        if (modifierGroup != null) {
            modifierGroup.setDisplayOrder(newOrder);
            modifierGroup.setUpdatedAt(new Date());
            modifierGroup.setDirty(true);
            modifierGroupDao.update(modifierGroup);
            return true;
        }
        return false;
    }

    public long getModifierGroupCount() throws SQLException {
        QueryBuilder<ModifierGroup, String> queryBuilder = modifierGroupDao.queryBuilder();
        queryBuilder.where().eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getActiveModifierGroupCount() throws SQLException {
        QueryBuilder<ModifierGroup, String> queryBuilder = modifierGroupDao.queryBuilder();
        queryBuilder.where()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }
}