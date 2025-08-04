package com.acf.pos.restaurant.backend.entity;

/**
 * Enum representing different table styles for floor planning
 */
public enum TableStyle {
    SQUARE("Square", 4, 80, 80),
    RECTANGLE("Rectangle", 6, 120, 80),
    CIRCLE("Circle", 4, 80, 80),
    OVAL("Oval", 6, 120, 80),
    LONG_BAR("Long Bar", 8, 200, 60),
    BOOTH("Booth", 4, 100, 120),
    HIGH_TOP("High Top", 4, 70, 70),
    COUNTER("Counter", 10, 300, 40);

    private final String displayName;
    private final int defaultCapacity;
    private final int defaultWidth;
    private final int defaultHeight;

    TableStyle(String displayName, int defaultCapacity, int defaultWidth, int defaultHeight) {
        this.displayName = displayName;
        this.defaultCapacity = defaultCapacity;
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getDefaultCapacity() {
        return defaultCapacity;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }
}