package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Entity representing a restaurant floor plan layout
 * Supports multiple floors (Main Dining, Patio, Bar, etc.)
 */
@DatabaseTable(tableName = "floor_plan")
public class FloorPlan extends BaseEntity {

    @DatabaseField(foreign = true, canBeNull = false, columnName = "restaurant_id")
    private Restaurant restaurant;

    @DatabaseField(canBeNull = false, columnName = "name")
    private String name;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "width_pixels")
    private Integer widthPixels;

    @DatabaseField(columnName = "height_pixels")
    private Integer heightPixels;

    @DatabaseField(columnName = "background_color")
    private String backgroundColor;

    @DatabaseField(columnName = "background_image_url")
    private String backgroundImageUrl;

    @DatabaseField(columnName = "grid_size")
    private Integer gridSize = 20; // For snap-to-grid functionality

    @DatabaseField(columnName = "is_active")
    private boolean isActive = true;

    @DatabaseField(columnName = "is_default")
    private boolean isDefault = false;

    @DatabaseField(columnName = "display_order")
    private Integer displayOrder;

    // Constructors
    public FloorPlan() {}

}