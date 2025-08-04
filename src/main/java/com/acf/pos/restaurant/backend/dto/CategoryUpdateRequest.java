package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;

/**
 * Portable DTO for category update requests
 * No framework-specific annotations - works on Android and Spring Boot
 */
public class CategoryUpdateRequest {

    private String parentCategoryId;
    private String name;
    private String bilingualName;
    private String description;
    private Integer displayOrder;
    private Boolean isActive;
    private String colorCode;
    private String iconUrl;
    private String kitchenDisplayName;

    // Constructors
    public CategoryUpdateRequest() {}

    // Validation method
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        
        Validator.validateNotBlank(name, "Category name", result);
        Validator.validateMaxLength(name, 255, "Category name", result);
        Validator.validateMaxLength(bilingualName, 255, "Bilingual name", result);
        Validator.validateMaxLength(description, 1000, "Description", result);
        Validator.validateMaxLength(colorCode, 7, "Color code", result);
        Validator.validateMaxLength(iconUrl, 500, "Icon URL", result);
        Validator.validateMaxLength(kitchenDisplayName, 255, "Kitchen display name", result);
        
        return result;
    }

    // Getters and Setters
    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBilingualName() {
        return bilingualName;
    }

    public void setBilingualName(String bilingualName) {
        this.bilingualName = bilingualName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getKitchenDisplayName() {
        return kitchenDisplayName;
    }

    public void setKitchenDisplayName(String kitchenDisplayName) {
        this.kitchenDisplayName = kitchenDisplayName;
    }
}