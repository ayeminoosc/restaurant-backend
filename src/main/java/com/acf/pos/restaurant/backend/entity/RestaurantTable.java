package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Entity representing a table in a restaurant floor plan
 * Supports drag-and-drop positioning and various table styles
 */
@DatabaseTable(tableName = "restaurant_table")
public class RestaurantTable extends BaseEntity {

    @DatabaseField(foreign = true, canBeNull = false, columnName = "restaurant_id")
    private Restaurant restaurant;

    @DatabaseField(foreign = true, canBeNull = false, columnName = "floor_plan_id")
    private FloorPlan floorPlan;

    @DatabaseField(canBeNull = false, columnName = "table_number")
    private String tableNumber;

    @DatabaseField(columnName = "table_name")
    private String tableName;

    @DatabaseField(canBeNull = false, columnName = "table_style")
    private TableStyle tableStyle;

    @DatabaseField(canBeNull = false, columnName = "x_position")
    private Integer xPosition;

    @DatabaseField(canBeNull = false, columnName = "y_position")
    private Integer yPosition;

    @DatabaseField(columnName = "width_pixels")
    private Integer widthPixels;

    @DatabaseField(columnName = "height_pixels")
    private Integer heightPixels;

    @DatabaseField(columnName = "rotation_degrees")
    private Integer rotationDegrees = 0;

    @DatabaseField(columnName = "capacity")
    private Integer capacity;

    @DatabaseField(columnName = "min_capacity")
    private Integer minCapacity;

    @DatabaseField(columnName = "max_capacity")
    private Integer maxCapacity;

    @DatabaseField(columnName = "is_active")
    private boolean isActive = true;

    @DatabaseField(columnName = "is_reservable")
    private boolean isReservable = true;

    @DatabaseField(columnName = "color_code")
    private String colorCode;

    @DatabaseField(columnName = "notes")
    private String notes;

    @DatabaseField(columnName = "section_name")
    private String sectionName;

    @DatabaseField(columnName = "server_station")
    private String serverStation;

    // Constructors
    public RestaurantTable() {}

    // Getters and Setters
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public FloorPlan getFloorPlan() {
        return floorPlan;
    }

    public void setFloorPlan(FloorPlan floorPlan) {
        this.floorPlan = floorPlan;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public TableStyle getTableStyle() {
        return tableStyle;
    }

    public void setTableStyle(TableStyle tableStyle) {
        this.tableStyle = tableStyle;
    }

    public Integer getXPosition() {
        return xPosition;
    }

    public void setXPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getYPosition() {
        return yPosition;
    }

    public void setYPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public Integer getWidthPixels() {
        return widthPixels;
    }

    public void setWidthPixels(Integer widthPixels) {
        this.widthPixels = widthPixels;
    }

    public Integer getHeightPixels() {
        return heightPixels;
    }

    public void setHeightPixels(Integer heightPixels) {
        this.heightPixels = heightPixels;
    }

    public Integer getRotationDegrees() {
        return rotationDegrees;
    }

    public void setRotationDegrees(Integer rotationDegrees) {
        this.rotationDegrees = rotationDegrees;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        this.minCapacity = minCapacity;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isReservable() {
        return isReservable;
    }

    public void setReservable(boolean reservable) {
        isReservable = reservable;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getServerStation() {
        return serverStation;
    }

    public void setServerStation(String serverStation) {
        this.serverStation = serverStation;
    }
}