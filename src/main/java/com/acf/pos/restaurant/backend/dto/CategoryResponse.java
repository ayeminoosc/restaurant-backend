package com.acf.pos.restaurant.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryResponse {

    private String id;

    @JsonProperty("restaurant_id")
    private String restaurantId;

    @JsonProperty("parent_category_id")
    private String parentCategoryId;

    private String name;

    @JsonProperty("bilingual_name")
    private String bilingualName;

    private String description;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("color_code")
    private String colorCode;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("tax_applicable")
    private Boolean taxApplicable;

    @JsonProperty("kitchen_display_name")
    private String kitchenDisplayName;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}