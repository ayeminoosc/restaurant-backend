package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MenuItemCreateRequest {

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("item_code")
    private String itemCode;

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    private String description;

    private Double price;

    @JsonProperty("is_available")
    private boolean available = true;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("preparation_time")
    private Integer preparationTimeMinutes;

    private Integer calories;

    @JsonProperty("allergen_info")
    private String allergenInfo;

    @JsonProperty("spice_level")
    private Integer spiceLevel;

    @JsonProperty("is_vegetarian")
    private Boolean isVegetarian = false;

    @JsonProperty("is_vegan")
    private Boolean isVegan = false;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_available")
    private Boolean isAvailable = true;

    @JsonProperty("color_code")
    private String colorCode;

    @JsonProperty("modifier_group_ids")
    private List<String> modifierGroupIds;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (Validator.isBlank(categoryId)) {
            result.addError("Category ID is required");
        }

        if (Validator.isBlank(itemCode)) {
            result.addError("Item code is required");
        }

        if (Validator.isBlank(name)) {
            result.addError("Menu item name is required");
        }

        if (name != null && name.length() > 255) {
            result.addError("Menu item name cannot exceed 255 characters");
        }

        if (price == null || price < 0) {
            result.addError("Price must be a positive number");
        }

        if (spiceLevel != null && (spiceLevel < 0 || spiceLevel > 5)) {
            result.addError("Spice level must be between 0 and 5");
        }

        if (preparationTimeMinutes != null && preparationTimeMinutes < 0) {
            result.addError("Preparation time cannot be negative");
        }

        if (calories != null && calories < 0) {
            result.addError("Calories cannot be negative");
        }

        return result;
    }
}