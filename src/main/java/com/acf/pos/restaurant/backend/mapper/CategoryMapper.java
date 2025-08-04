package com.acf.pos.restaurant.backend.mapper;

import com.acf.pos.restaurant.backend.dto.CategoryCreateRequest;
import com.acf.pos.restaurant.backend.dto.CategoryResponse;
import com.acf.pos.restaurant.backend.dto.CategoryUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Category;
import com.acf.pos.restaurant.backend.entity.Restaurant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Portable CategoryMapper - works on Android and Spring Boot
 * No framework-specific dependencies
 */
public class CategoryMapper {

    public Category toEntity(CategoryCreateRequest request) {
        if (request == null) {
            return null;
        }

        Category category = new Category();
        
        // Set restaurant reference
        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getRestaurantId());
        category.setRestaurant(restaurant);

        // Set parent category reference if provided
        if (request.getParentCategoryId() != null) {
            Category parentCategory = new Category();
            parentCategory.setId(request.getParentCategoryId());
            category.setParentCategory(parentCategory);
        }

        category.setName(request.getName());
        category.setBilingualName(request.getBilingualName());
        category.setDescription(request.getDescription());
        category.setDisplayOrder(request.getDisplayOrder());
        category.setActive(request.getIsActive() != null ? request.getIsActive() : true);
        category.setColorCode(request.getColorCode());
        category.setIconUrl(request.getIconUrl());

        return category;
    }

    public void updateEntity(Category category, CategoryUpdateRequest request) {
        if (request == null || category == null) {
            return;
        }

        // Set parent category reference if provided
        if (request.getParentCategoryId() != null) {
            Category parentCategory = new Category();
            parentCategory.setId(request.getParentCategoryId());
            category.setParentCategory(parentCategory);
        } else {
            category.setParentCategory(null);
        }

        category.setName(request.getName());
        category.setBilingualName(request.getBilingualName());
        category.setDescription(request.getDescription());
        category.setDisplayOrder(request.getDisplayOrder());
        
        if (request.getIsActive() != null) {
            category.setActive(request.getIsActive());
        }
        
        category.setColorCode(request.getColorCode());
        category.setIconUrl(request.getIconUrl());
        
    }

    public CategoryResponse toResponse(Category category) {
        if (category == null) {
            return null;
        }

        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setRestaurantId(category.getRestaurant() != null ? category.getRestaurant().getId() : null);
        response.setParentCategoryId(category.getParentCategory() != null ? category.getParentCategory().getId() : null);
        response.setName(category.getName());
        response.setBilingualName(category.getBilingualName());
        response.setDescription(category.getDescription());
        response.setDisplayOrder(category.getDisplayOrder());
        response.setIsActive(category.isActive());
        response.setColorCode(category.getColorCode());
        response.setIconUrl(category.getIconUrl());
        // Convert Date to LocalDateTime
        if (category.getCreatedAt() != null) {
            response.setCreatedAt(LocalDateTime.ofInstant(
                category.getCreatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }
        
        if (category.getUpdatedAt() != null) {
            response.setUpdatedAt(LocalDateTime.ofInstant(
                category.getUpdatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }

        return response;
    }

    public List<CategoryResponse> toResponseList(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        
        List<CategoryResponse> responses = new ArrayList<>();
        for (Category category : categories) {
            responses.add(toResponse(category));
        }
        return responses;
    }
}