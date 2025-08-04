package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrefixUpdateRequest {

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("color_code")
    private String colorCode;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (name != null && Validator.isBlank(name)) {
            result.addError("Prefix name cannot be empty");
        }

        if (name != null && name.length() > 50) {
            result.addError("Prefix name cannot exceed 50 characters");
        }

        return result;
    }
}