package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ModifierCreateRequest {

    @JsonProperty("modifier_group_id")
    private String modifierGroupId;

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    private Double price = 0.0;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_active")
    private Boolean isActive = true;

    @JsonProperty("is_default")
    private Boolean isDefault = false;

    @JsonProperty("prefix_ids")
    private List<String> prefixIds;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (Validator.isBlank(modifierGroupId)) {
            result.addError("Modifier group ID is required");
        }

        if (Validator.isBlank(name)) {
            result.addError("Modifier name is required");
        }

        if (name != null && name.length() > 255) {
            result.addError("Modifier name cannot exceed 255 characters");
        }

        if (price == null || price < 0) {
            result.addError("Price must be a positive number or zero");
        }

        return result;
    }
}