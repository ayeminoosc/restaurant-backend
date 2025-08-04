package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.common.Logger;
import com.acf.pos.restaurant.backend.common.LoggerFactory;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.dto.CategoryCreateRequest;
import com.acf.pos.restaurant.backend.dto.CategoryUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Category;
import com.acf.pos.restaurant.backend.entity.Restaurant;
import com.acf.pos.restaurant.backend.exception.ResourceNotFoundException;
import com.acf.pos.restaurant.backend.exception.ValidationException;
import com.acf.pos.restaurant.backend.mapper.CategoryMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Portable CategoryService - works on Android and Spring Boot
 * No framework-specific dependencies
 */
public class CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final Dao<Category, String> categoryDao;
    private final Dao<Restaurant, String> restaurantDao;
    private final CategoryMapper categoryMapper;
    private final TransactionManager transactionManager;

    // Constructor injection for portability
    public CategoryService(
            Dao<Category, String> categoryDao,
            Dao<Restaurant, String> restaurantDao,
            CategoryMapper categoryMapper,
            TransactionManager transactionManager) {
        this.categoryDao = categoryDao;
        this.restaurantDao = restaurantDao;
        this.categoryMapper = categoryMapper;
        this.transactionManager = transactionManager;
    }

    public Category createCategory(CategoryCreateRequest request) throws SQLException {
        log.info("Creating category with name: %s for restaurant: %s", request.getName(), request.getRestaurantId());
        
        // Validate input
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            // Validate restaurant exists
            Restaurant restaurant = restaurantDao.queryForId(request.getRestaurantId());
            if (restaurant == null) {
                log.warn("Restaurant not found with ID: %s", request.getRestaurantId());
                throw new ResourceNotFoundException("Restaurant", request.getRestaurantId());
            }
            
            // Validate parent category if provided
            Category parentCategory = null;
            if (request.getParentCategoryId() != null) {
                parentCategory = categoryDao.queryForId(request.getParentCategoryId());
                if (parentCategory == null) {
                    log.warn("Parent category not found with ID: %s", request.getParentCategoryId());
                    throw new ResourceNotFoundException("Category", request.getParentCategoryId());
                }
                
                // Ensure parent belongs to same restaurant
                if (!parentCategory.getRestaurant().getId().equals(request.getRestaurantId())) {
                    throw new ValidationException("Parent category must belong to the same restaurant");
                }
            }
            
            // Convert DTO to entity
            Category category = categoryMapper.toEntity(request);
            category.setRestaurant(restaurant);
            category.setParentCategory(parentCategory);
            
            // Set audit fields
            Date now = new Date();
            category.setCreatedAt(now);
            category.setUpdatedAt(now);
            category.setDirty(true);
            
            categoryDao.create(category);
            
            log.info("Successfully created category with ID: %s", category.getId());
            return category;
        });
    }

    public Category updateCategory(String categoryId, CategoryUpdateRequest request) throws SQLException {
        log.info("Updating category with ID: %s", categoryId);
        
        // Validate input
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            // Validate category exists
            Category existingCategory = categoryDao.queryForId(categoryId);
            if (existingCategory == null) {
                log.warn("Category not found with ID: %s", categoryId);
                throw new ResourceNotFoundException("Category", categoryId);
            }
            
            // Validate parent category if provided
            if (request.getParentCategoryId() != null) {
                Category parentCategory = categoryDao.queryForId(request.getParentCategoryId());
                if (parentCategory == null) {
                    log.warn("Parent category not found with ID: %s", request.getParentCategoryId());
                    throw new ResourceNotFoundException("Category", request.getParentCategoryId());
                }
                
                // Ensure parent belongs to same restaurant
                if (!parentCategory.getRestaurant().getId().equals(existingCategory.getRestaurant().getId())) {
                    throw new ValidationException("Parent category must belong to the same restaurant");
                }
                
                // Prevent circular reference
                if (parentCategory.getId().equals(categoryId)) {
                    throw new ValidationException("Category cannot be its own parent");
                }
            }
            
            // Update entity with request data
            categoryMapper.updateEntity(existingCategory, request);
            
            // Set audit fields
            existingCategory.setUpdatedAt(new Date());
            existingCategory.setDirty(true);
            
            categoryDao.update(existingCategory);
            
            log.info("Successfully updated category with ID: %s", categoryId);
            return existingCategory;
        });
    }

    public Category getCategoryById(String id) throws SQLException {
        log.debug("Retrieving category with ID: %s", id);
        
        Category category = categoryDao.queryForId(id);
        if (category == null) {
            log.warn("Category not found with ID: %s", id);
            throw new ResourceNotFoundException("Category", id);
        }
        return category;
    }

    public List<Category> getAllCategoriesByRestaurant(String restaurantId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("restaurant_id", restaurantId)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Category> getActiveCategoriesByRestaurant(String restaurantId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("restaurant_id", restaurantId)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }



    public boolean deleteCategory(String id) throws SQLException {
        Category category = categoryDao.queryForId(id);
        if (category != null) {
            category.setDeleted(true);
            category.setUpdatedAt(new Date());
            category.setDirty(true);
            categoryDao.update(category);
            return true;
        }
        return false;
    }

    public boolean toggleCategoryStatus(String id) throws SQLException {
        Category category = categoryDao.queryForId(id);
        if (category != null) {
            category.setActive(!category.isActive());
            category.setUpdatedAt(new Date());
            category.setDirty(true);
            categoryDao.update(category);
            return true;
        }
        return false;
    }

    public boolean updateDisplayOrder(String id, Integer newOrder) throws SQLException {
        Category category = categoryDao.queryForId(id);
        if (category != null) {
            category.setDisplayOrder(newOrder);
            category.setUpdatedAt(new Date());
            category.setDirty(true);
            categoryDao.update(category);
            return true;
        }
        return false;
    }

    public List<Category> getTopLevelCategories(String restaurantId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("restaurant_id", restaurantId)
                .and()
                .isNull("parent_category_id")
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Category> getActiveTopLevelCategories(String restaurantId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("restaurant_id", restaurantId)
                .and()
                .isNull("parent_category_id")
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Category> getSubCategories(String parentCategoryId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("parent_category_id", parentCategoryId)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public List<Category> getActiveSubCategories(String parentCategoryId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("parent_category_id", parentCategoryId)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("display_order", true);
        return queryBuilder.query();
    }

    public long getCategoryCount(String restaurantId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("restaurant_id", restaurantId)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getTopLevelCategoryCount(String restaurantId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("restaurant_id", restaurantId)
                .and()
                .isNull("parent_category_id")
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getSubCategoryCount(String parentCategoryId) throws SQLException {
        QueryBuilder<Category, String> queryBuilder = categoryDao.queryBuilder();
        queryBuilder.where()
                .eq("parent_category_id", parentCategoryId)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }
}