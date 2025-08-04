package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;

/**
 * DTO for updating table position during drag-and-drop operations
 * Optimized for frequent position updates
 */
public class TablePositionUpdateRequest {

    private Integer xPosition;
    private Integer yPosition;
    private Integer rotationDegrees;

    // Constructors
    public TablePositionUpdateRequest() {}

    public TablePositionUpdateRequest(Integer xPosition, Integer yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public TablePositionUpdateRequest(Integer xPosition, Integer yPosition, Integer rotationDegrees) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.rotationDegrees = rotationDegrees;
    }

    // Validation
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        
        if (xPosition != null && xPosition < 0) {
            result.addError("X position cannot be negative");
        }
        
        if (yPosition != null && yPosition < 0) {
            result.addError("Y position cannot be negative");
        }
        
        if (rotationDegrees != null && (rotationDegrees < 0 || rotationDegrees >= 360)) {
            result.addError("Rotation degrees must be between 0 and 359");
        }
        
        return result;
    }

    // Getters and Setters
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

    public Integer getRotationDegrees() {
        return rotationDegrees;
    }

    public void setRotationDegrees(Integer rotationDegrees) {
        this.rotationDegrees = rotationDegrees;
    }
}