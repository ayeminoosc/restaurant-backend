package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.common.Logger;
import com.acf.pos.restaurant.backend.common.LoggerFactory;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.dto.RestaurantCreateRequest;
import com.acf.pos.restaurant.backend.dto.RestaurantUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Organization;
import com.acf.pos.restaurant.backend.entity.Restaurant;
import com.acf.pos.restaurant.backend.exception.ResourceNotFoundException;
import com.acf.pos.restaurant.backend.exception.ValidationException;
import com.acf.pos.restaurant.backend.mapper.RestaurantMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Component
public class RestaurantService {

    private static final Logger log = LoggerFactory.getLogger(RestaurantService.class);

    private final Dao<Restaurant, String> restaurantDao;
    private final Dao<Organization, String> organizationDao;
    private final RestaurantMapper restaurantMapper;
    private final TransactionManager transactionManager;

    public RestaurantService(
            Dao<Restaurant, String> restaurantDao,
            Dao<Organization, String> organizationDao,
            RestaurantMapper restaurantMapper,
            TransactionManager transactionManager) {
        this.restaurantDao = restaurantDao;
        this.organizationDao = organizationDao;
        this.restaurantMapper = restaurantMapper;
        this.transactionManager = transactionManager;
    }

    public Restaurant createRestaurant(RestaurantCreateRequest request) throws SQLException {
        log.info("Creating restaurant with name: %s for organization: %s", request.getName(), request.getOrganizationId());
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            Organization organization = organizationDao.queryForId(request.getOrganizationId());
            if (organization == null) {
                log.warn("Organization not found with ID: %s", request.getOrganizationId());
                throw new ResourceNotFoundException("Organization", request.getOrganizationId());
            }
            
            Restaurant restaurant = restaurantMapper.toEntity(request);
            restaurant.setOrganization(organization);
            
            Date now = new Date();
            restaurant.setCreatedAt(now);
            restaurant.setUpdatedAt(now);
            restaurant.setDirty(true);
            
            restaurantDao.create(restaurant);
            
            log.info("Successfully created restaurant with ID: %s", restaurant.getId());
            return restaurant;
        });
    }

    public Restaurant updateRestaurant(String restaurantId, RestaurantUpdateRequest request) throws SQLException {
        log.info("Updating restaurant with ID: %s", restaurantId);
        
        ValidationResult validation = request.validate();
        if (validation.hasErrors()) {
            throw new ValidationException(validation.getFirstError());
        }
        
        return transactionManager.executeInTransaction(() -> {
            Restaurant existingRestaurant = restaurantDao.queryForId(restaurantId);
            if (existingRestaurant == null) {
                log.warn("Restaurant not found with ID: %s", restaurantId);
                throw new ResourceNotFoundException("Restaurant", restaurantId);
            }
            
            restaurantMapper.updateEntity(existingRestaurant, request);
            
            existingRestaurant.setUpdatedAt(new Date());
            existingRestaurant.setDirty(true);
            
            restaurantDao.update(existingRestaurant);
            
            log.info("Successfully updated restaurant with ID: %s", restaurantId);
            return existingRestaurant;
        });
    }

    public Restaurant getRestaurantById(String id) throws SQLException {
        log.debug("Retrieving restaurant with ID: %s", id);
        
        Restaurant restaurant = restaurantDao.queryForId(id);
        if (restaurant == null) {
            log.warn("Restaurant not found with ID: %s", id);
            throw new ResourceNotFoundException("Restaurant", id);
        }
        return restaurant;
    }

    public List<Restaurant> getAllRestaurantsByOrganization(String organizationId) throws SQLException {
        QueryBuilder<Restaurant, String> queryBuilder = restaurantDao.queryBuilder();
        queryBuilder.where()
                .eq("organization_id", organizationId)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("name", true);
        return queryBuilder.query();
    }

    public List<Restaurant> getActiveRestaurantsByOrganization(String organizationId) throws SQLException {
        QueryBuilder<Restaurant, String> queryBuilder = restaurantDao.queryBuilder();
        queryBuilder.where()
                .eq("organization_id", organizationId)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        queryBuilder.orderBy("name", true);
        return queryBuilder.query();
    }

    public boolean deleteRestaurant(String id) throws SQLException {
        Restaurant restaurant = restaurantDao.queryForId(id);
        if (restaurant != null) {
            restaurant.setDeleted(true);
            restaurant.setUpdatedAt(new Date());
            restaurant.setDirty(true);
            restaurantDao.update(restaurant);
            return true;
        }
        return false;
    }

    public boolean toggleRestaurantStatus(String id) throws SQLException {
        Restaurant restaurant = restaurantDao.queryForId(id);
        if (restaurant != null) {
            restaurant.setActive(!restaurant.isActive());
            restaurant.setUpdatedAt(new Date());
            restaurant.setDirty(true);
            restaurantDao.update(restaurant);
            return true;
        }
        return false;
    }

    public long getRestaurantCount(String organizationId) throws SQLException {
        QueryBuilder<Restaurant, String> queryBuilder = restaurantDao.queryBuilder();
        queryBuilder.where()
                .eq("organization_id", organizationId)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }

    public long getActiveRestaurantCount(String organizationId) throws SQLException {
        QueryBuilder<Restaurant, String> queryBuilder = restaurantDao.queryBuilder();
        queryBuilder.where()
                .eq("organization_id", organizationId)
                .and()
                .eq("is_active", true)
                .and()
                .eq("deleted", false);
        return queryBuilder.countOf();
    }
}