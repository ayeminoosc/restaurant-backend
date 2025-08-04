package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.common.Logger;
import com.acf.pos.restaurant.backend.common.LoggerFactory;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.dto.MenuItemCreateRequest;
import com.acf.pos.restaurant.backend.dto.MenuItemUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Category;
import com.acf.pos.restaurant.backend.entity.MenuItem;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;
import com.acf.pos.restaurant.backend.exception.ResourceNotFoundException;
import com.acf.pos.restaurant.backend.exception.ValidationException;
import com.acf.pos.restaurant.backend.mapper.MenuItemMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Component
public class MenuItemService {

    private static final Logger log = LoggerFactory.getLogger(MenuItemService.class);

    private final Dao<MenuItem, String> menuItemDao;
    private final Dao<Category, String> categoryDao;
    private final Dao<ModifierGroup, String> modifierGroupDao;
    private final MenuItemMapper menuItemMapper;
    private final TransactionManager transactionManager;

    public MenuItemService(
            Dao<MenuItem, String> menuItemDao,
            Dao<Category, String> categoryDao,
            Dao<ModifierGroup, String> modifierGroupDao,
            MenuItemMapper menuItemMapper,
            TransactionManager transactionManager) {
        this.menuItemDao = menuItemDao;
        this.categoryDao = categoryDao;
        this.modifierGroupDao = modifierGroupDao;
        this.menuItemMapper = menuItemMapper;
        this.transactionManager = transactionManager;
    }

    public MenuItem createMenuItem(MenuItemCreateRequest request) throws SQLException {
        log.info("Creating menu item with name: %s for category: %s", request.getName(), request.getCategoryId());
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            Category category = categoryDao.queryForId(request.getCategoryId());
            if (category == null) {
                log.warn("Category not found with ID: %s", request.getCategoryId());
                throw new ResourceNotFoundException("Category", request.getCategoryId());
            }
            
            MenuItem menuItem = menuItemMapper.toEntity(request);
            menuItem.setCategory(category);
            
            Date now = new Date();
            menuItem.setCreatedAt(now);
            menuItem.setUpdatedAt(now);
            menuItem.setDirty(true);
            
            menuItemDao.create(menuItem);
            
            log.info("Successfully created menu item with ID: %s", menuItem.getId());
            return menuItem;
        });
    }

    public MenuItem updateMenuItem(String menuItemId, MenuItemUpdateRequest request) throws SQLException {
        log.info("Updating menu item with ID: %s", menuItemId);
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            MenuItem existingMenuItem = menuItemDao.queryForId(menuItemId);
            if (existingMenuItem == null) {
                log.warn("Menu item not found with ID: %s", menuItemId);
                throw new ResourceNotFoundException("MenuItem", menuItemId);
            }
            
            if (request.getCategoryId() != null) {
                Category category = categoryDao.queryForId(request.getCategoryId());
                if (category == null) {
                    log.warn("Category not found with ID: %s", request.getCategoryId());
                    throw new ResourceNotFoundException("Category", request.getCategoryId());
                }
                existingMenuItem.setCategory(category);
            }
            
            menuItemMapper.updateEntity(existingMenuItem, request);
            
            existingMenuItem.setUpdatedAt(new Date());
            existingMenuItem.setDirty(true);
            
            menuItemDao.update(existingMenuItem);
            
            log.info("Successfully updated menu item with ID: %s", menuItemId);
            return existingMenuItem;
        });
    }

    public MenuItem getMenuItemById(String id) throws SQLException {
        log.debug("Retrieving menu item with ID: %s", id);
        
        MenuItem menuItem = menuItemDao.queryForId(id);
        if (menuItem == null) {
            log.warn("Menu item not found with ID: %s", id);
            throw new ResourceNotFoundException("MenuItem", id);
        }
        return menuItem;
    }

    public List<MenuItem> getAllMenuItemsByCategory(String categoryId) throws SQLException {
        QueryBuilder<MenuItem, String> queryBuilder = menuItemDao.queryBuilder();
        queryBuilder.where()
                .eq("category_id", categoryId)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<MenuItem> getActiveMenuItemsByCategory(String categoryId) throws SQLException {
        QueryBuilder<MenuItem, String> queryBuilder = menuItemDao.queryBuilder();
        queryBuilder.where()
                .eq("category_id", categoryId)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<MenuItem> getAvailableMenuItemsByCategory(String categoryId) throws SQLException {
        QueryBuilder<MenuItem, String> queryBuilder = menuItemDao.queryBuilder();
        queryBuilder.where()
                .eq("category_id", categoryId)
                .and()
                .eq("is_available", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public boolean deleteMenuItem(String id) throws SQLException {
        MenuItem menuItem = menuItemDao.queryForId(id);
        if (menuItem != null) {
            menuItem.setDeleted(true);
            menuItem.setUpdatedAt(new Date());
            menuItem.setDirty(true);
            menuItemDao.update(menuItem);
            return true;
        }
        return false;
    }

    // MenuItem doesn't have an active field, only availability

    public boolean toggleMenuItemAvailability(String id) throws SQLException {
        MenuItem menuItem = menuItemDao.queryForId(id);
        if (menuItem != null) {
            menuItem.setAvailable(!menuItem.isAvailable());
            menuItem.setUpdatedAt(new Date());
            menuItem.setDirty(true);
            menuItemDao.update(menuItem);
            return true;
        }
        return false;
    }

    public boolean updateDisplayOrder(String id, Integer newOrder) throws SQLException {
        MenuItem menuItem = menuItemDao.queryForId(id);
        if (menuItem != null) {
            menuItem.setDisplayOrder(newOrder);
            menuItem.setUpdatedAt(new Date());
            menuItem.setDirty(true);
            menuItemDao.update(menuItem);
            return true;
        }
        return false;
    }

    public long getMenuItemCount(String categoryId) throws SQLException {
        QueryBuilder<MenuItem, String> queryBuilder = menuItemDao.queryBuilder();
        queryBuilder.where()
                .eq("category_id", categoryId)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getActiveMenuItemCount(String categoryId) throws SQLException {
        QueryBuilder<MenuItem, String> queryBuilder = menuItemDao.queryBuilder();
        queryBuilder.where()
                .eq("category_id", categoryId)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }
}