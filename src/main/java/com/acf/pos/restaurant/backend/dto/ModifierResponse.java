package com.acf.pos.restaurant.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ModifierResponse {

    private String id;

    @JsonProperty("modifier_group_id")
    private String modifierGroupId;

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

    private List<PrefixResponse> prefixes;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}