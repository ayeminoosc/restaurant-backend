package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModifierGroupCreateRequest {

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    @JsonProperty("min_selection")
    private Integer minSelection = 0;

    @JsonProperty("max_selection")
    private Integer maxSelection = 1;

    @JsonProperty("multiple_selection")
    private Boolean multipleSelection = false;

    private Boolean required = false;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_active")
    private Boolean isActive = true;

    @JsonProperty("color_code")
    private String colorCode;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (Validator.isBlank(name)) {
            result.addError("Modifier group name is required");
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