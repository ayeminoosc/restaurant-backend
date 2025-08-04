package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import lombok.Data;

/**
 * Portable DTO for category creation requests
 * No framework-specific annotations - works on Android and Spring Boot
 */
@Data
public class CategoryCreateRequest {

    private String restaurantId;
    private String parentCategoryId;
    private String name;
    private String bilingualName;
    private String description;
    private Integer displayOrder;
    private Boolean isActive = true;
    private String colorCode;
    private String iconUrl;
    private Boolean taxApplicable = true;

    // Constructors
    public CategoryCreateRequest() {}

    // Validation method
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        
        Validator.validateNotBlank(restaurantId, "Restaurant ID", result);
        Validator.validateNotBlank(name, "Category name", result);
        Validator.validateMaxLength(name, 255, "Category name", result);
        Validator.validateMaxLength(bilingualName, 255, "Bilingual name", result);
        Validator.validateMaxLength(description, 1000, "Description", result);
        Validator.validateMaxLength(colorCode, 7, "Color code", result);
        Validator.validateMaxLength(iconUrl, 500, "Icon URL", result);

        return result;
    }

}