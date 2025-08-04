package com.acf.pos.restaurant.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MenuItemResponse {

    private String id;

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
    private boolean  available;

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
    private Boolean isVegetarian;

    @JsonProperty("is_vegan")
    private Boolean isVegan;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("color_code")
    private String colorCode;

    @JsonProperty("modifier_groups")
    private List<ModifierGroupResponse> modifierGroups;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}