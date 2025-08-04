package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ModifierUpdateRequest {

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    private Double price;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("is_default")
    private Boolean isDefault;

    @JsonProperty("prefix_ids")
    private List<String> prefixIds;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (name != null && Validator.isBlank(name)) {
            result.addError("Modifier name cannot be empty");
        }

        if (name != null && name.length() > 255) {
            result.addError("Modifier name cannot exceed 255 characters");
        }

        if (price != null && price < 0) {
            result.addError("Price must be a positive number or zero");
        }

        return result;
    }
}