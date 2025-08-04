package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.acf.pos.restaurant.backend.entity.TableStyle;

/**
 * DTO for creating a new table in a floor plan
 */
public class TableCreateRequest {

    private String restaurantId;
    private String floorPlanId;
    private String tableNumber;
    private String tableName;
    private TableStyle tableStyle;
    private Integer xPosition;
    private Integer yPosition;
    private Integer widthPixels;
    private Integer heightPixels;
    private Integer rotationDegrees = 0;
    private Integer capacity;
    private Integer minCapacity;
    private Integer maxCapacity;
    private Boolean isActive = true;
    private Boolean isReservable = true;
    private String colorCode;
    private String notes;
    private String sectionName;
    private String serverStation;

    // Constructors
    public TableCreateRequest() {}

    // Validation
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        
        Validator.validateNotBlank(restaurantId, "Restaurant ID", result);
        Validator.validateNotBlank(floorPlanId, "Floor plan ID", result);
        Validator.validateNotBlank(tableNumber, "Table number", result);
        Validator.validateMaxLength(tableNumber, 50, "Table number", result);
        Validator.validateMaxLength(tableName, 255, "Table name", result);
        Validator.validateNotNull(tableStyle, "Table style", result);
        Validator.validateNotNull(xPosition, "X position", result);
        Validator.validateNotNull(yPosition, "Y position", result);
        Validator.validateMaxLength(colorCode, 7, "Color code", result);
        Validator.validateMaxLength(notes, 1000, "Notes", result);
        Validator.validateMaxLength(sectionName, 255, "Section name", result);
        Validator.validateMaxLength(serverStation, 255, "Server station", result);
        
        if (xPosition != null && xPosition < 0) {
            result.addError("X position cannot be negative");
        }
        
        if (yPosition != null && yPosition < 0) {
            result.addError("Y position cannot be negative");
        }
        
        if (widthPixels != null && widthPixels <= 0) {
            result.addError("Width must be greater than 0");
        }
        
        if (heightPixels != null && heightPixels <= 0) {
            result.addError("Height must be greater than 0");
        }
        
        if (capacity != null && capacity <= 0) {
            result.addError("Capacity must be greater than 0");
        }
        
        if (minCapacity != null && minCapacity <= 0) {
            result.addError("Minimum capacity must be greater than 0");
        }
        
        if (maxCapacity != null && maxCapacity <= 0) {
            result.addError("Maximum capacity must be greater than 0");
        }
        
        if (minCapacity != null && maxCapacity != null && minCapacity > maxCapacity) {
            result.addError("Minimum capacity cannot be greater than maximum capacity");
        }
        
        return result;
    }

    // Getters and Setters
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFloorPlanId() {
        return floorPlanId;
    }

    public void setFloorPlanId(String floorPlanId) {
        this.floorPlanId = floorPlanId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsReservable() {
        return isReservable;
    }

    public void setIsReservable(Boolean isReservable) {
        this.isReservable = isReservable;
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