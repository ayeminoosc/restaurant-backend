package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;

/**
 * DTO for creating a new floor plan
 */
public class FloorPlanCreateRequest {

    private String restaurantId;
    private String name;
    private String description;
    private Integer widthPixels;
    private Integer heightPixels;
    private String backgroundColor;
    private String backgroundImageUrl;
    private Integer gridSize = 20;
    private Boolean isActive = true;
    private Boolean isDefault = false;
    private Integer displayOrder;

    // Constructors
    public FloorPlanCreateRequest() {}

    // Validation
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        
        Validator.validateNotBlank(restaurantId, "Restaurant ID", result);
        Validator.validateNotBlank(name, "Floor plan name", result);
        Validator.validateMaxLength(name, 255, "Floor plan name", result);
        Validator.validateMaxLength(description, 1000, "Description", result);
        Validator.validateMaxLength(backgroundColor, 7, "Background color", result);
        Validator.validateMaxLength(backgroundImageUrl, 500, "Background image URL", result);
        
        if (widthPixels != null && widthPixels <= 0) {
            result.addError("Width must be greater than 0");
        }
        
        if (heightPixels != null && heightPixels <= 0) {
            result.addError("Height must be greater than 0");
        }
        
        if (gridSize != null && gridSize <= 0) {
            result.addError("Grid size must be greater than 0");
        }
        
        return result;
    }

    // Getters and Setters
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWidthPixels() {
        return widthPixels;
    }

    public void setWidthPixels(Integer widthPixels) {
        this.widthPixels = widthPixels;
    }

    public Integer getHeightPixels() {
        return heightPixels;
    }

    public void setHeightPixels(Integer heightPixels) {
        this.heightPixels = heightPixels;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    public Integer getGridSize() {
        return gridSize;
    }

    public void setGridSize(Integer gridSize) {
        this.gridSize = gridSize;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}