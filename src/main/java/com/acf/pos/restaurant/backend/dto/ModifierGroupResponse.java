package com.acf.pos.restaurant.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ModifierGroupResponse {

    private String id;

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

    private List<ModifierResponse> modifiers;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}