package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModifierGroupUpdateRequest {

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    @JsonProperty("min_selection")
    private Integer minSelection;

    @JsonProperty("max_selection")
    private Integer maxSelection;

    @JsonProperty("multiple_selection")
    private Boolean multipleSelection;

    private Boolean required;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("color_code")
    private String colorCode;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (name != null && Validator.isBlank(name)) {
            result.addError("Modifier group name cannot be empty");
        }

        if (name != null && name.length() > 255) {
            result.addError("Modifier group name cannot exceed 255 characters");
        }

        if (minSelection != null && minSelection < 0) {
            result.addError("Minimum selection cannot be negative");
        }

        if (maxSelection != null && maxSelection < 1) {
            result.addError("Maximum selection must be at least 1");
        }

        if (minSelection != null && maxSelection != null && minSelection > maxSelection) {
            result.addError("Minimum selection cannot be greater than maximum selection");
        }

        return result;
    }
}