package com.acf.pos.restaurant.backend.mapper;

import com.acf.pos.restaurant.backend.dto.MenuItemCreateRequest;
import com.acf.pos.restaurant.backend.dto.MenuItemResponse;
import com.acf.pos.restaurant.backend.dto.MenuItemUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Category;
import com.acf.pos.restaurant.backend.entity.MenuItem;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MenuItemMapper {

    public MenuItem toEntity(MenuItemCreateRequest request) {
        if (request == null) {
            return null;
        }

        MenuItem menuItem = new MenuItem();
        
        Category category = new Category();
        category.setId(request.getCategoryId());
        menuItem.setCategory(category);

        menuItem.setItemCode(request.getItemCode());
        menuItem.setName(request.getName());
        menuItem.setBilingualName(request.getBilingualName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());
        menuItem.setAvailable(request.isAvailable());
        menuItem.setImageUrl(request.getImageUrl());
        menuItem.setPreparationTimeMinutes(request.getPreparationTimeMinutes());
        menuItem.setCalories(request.getCalories());
        menuItem.setAllergenInfo(request.getAllergenInfo());
        menuItem.setSpiceLevel(request.getSpiceLevel());
        menuItem.setIsVegetarian(request.getIsVegetarian() != null ? request.getIsVegetarian() : false);
        menuItem.setIsVegan(request.getIsVegan() != null ? request.getIsVegan() : false);
        menuItem.setDisplayOrder(request.getDisplayOrder());
//        menuItem.setActive(request.getIsActive() != null ? request.getIsActive() : true);
        menuItem.setColorCode(request.getColorCode());

        return menuItem;
    }

    public void updateEntity(MenuItem menuItem, MenuItemUpdateRequest request) {
        if (request == null || menuItem == null) {
            return;
        }

        if (request.getItemCode() != null) {
            menuItem.setItemCode(request.getItemCode());
        }
        if (request.getName() != null) {
            menuItem.setName(request.getName());
        }
        if (request.getBilingualName() != null) {
            menuItem.setBilingualName(request.getBilingualName());
        }
        if (request.getDescription() != null) {
            menuItem.setDescription(request.getDescription());
        }
        if (request.getPrice() != null) {
            menuItem.setPrice(request.getPrice());
        }
        menuItem.setAvailable(request.isAvailable());

        if (request.getImageUrl() != null) {
            menuItem.setImageUrl(request.getImageUrl());
        }
        if (request.getPreparationTimeMinutes() != null) {
            menuItem.setPreparationTimeMinutes(request.getPreparationTimeMinutes());
        }
        if (request.getCalories() != null) {
            menuItem.setCalories(request.getCalories());
        }
        if (request.getAllergenInfo() != null) {
            menuItem.setAllergenInfo(request.getAllergenInfo());
        }
        if (request.getSpiceLevel() != null) {
            menuItem.setSpiceLevel(request.getSpiceLevel());
        }
        if (request.getIsVegetarian() != null) {
            menuItem.setIsVegetarian(request.getIsVegetarian());
        }
        if (request.getIsVegan() != null) {
            menuItem.setIsVegan(request.getIsVegan());
        }
        if (request.getDisplayOrder() != null) {
            menuItem.setDisplayOrder(request.getDisplayOrder());
        }

        menuItem.setAvailable(request.isAvailable());

        if (request.getColorCode() != null) {
            menuItem.setColorCode(request.getColorCode());
        }
    }

    public MenuItemResponse toResponse(MenuItem menuItem) {
        if (menuItem == null) {
            return null;
        }

        MenuItemResponse response = new MenuItemResponse();
        response.setId(menuItem.getId());
        response.setCategoryId(menuItem.getCategory() != null ? menuItem.getCategory().getId() : null);
        response.setItemCode(menuItem.getItemCode());
        response.setName(menuItem.getName());
        response.setBilingualName(menuItem.getBilingualName());
        response.setDescription(menuItem.getDescription());
        response.setPrice(menuItem.getPrice());
        response.setAvailable(menuItem.isAvailable());
        response.setImageUrl(menuItem.getImageUrl());
        response.setPreparationTimeMinutes(menuItem.getPreparationTimeMinutes());
        response.setCalories(menuItem.getCalories());
        response.setAllergenInfo(menuItem.getAllergenInfo());
        response.setSpiceLevel(menuItem.getSpiceLevel());
        response.setIsVegetarian(menuItem.getIsVegetarian());
        response.setIsVegan(menuItem.getIsVegan());
        response.setDisplayOrder(menuItem.getDisplayOrder());
        response.setColorCode(menuItem.getColorCode());

        // ModifierGroups will be loaded separately if needed

        if (menuItem.getCreatedAt() != null) {
            response.setCreatedAt(LocalDateTime.ofInstant(
                menuItem.getCreatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }
        
        if (menuItem.getUpdatedAt() != null) {
            response.setUpdatedAt(LocalDateTime.ofInstant(
                menuItem.getUpdatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }

        return response;
    }

    public List<MenuItemResponse> toResponseList(List<MenuItem> menuItems) {
        if (menuItems == null) {
            return null;
        }
        
        List<MenuItemResponse> responses = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            responses.add(toResponse(menuItem));
        }
        return responses;
    }
}