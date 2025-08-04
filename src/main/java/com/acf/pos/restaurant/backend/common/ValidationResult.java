package com.acf.pos.restaurant.backend.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Portable validation result container
 */
public class ValidationResult {
    private final List<String> errors;
    
    public ValidationResult() {
        this.errors = new ArrayList<>();
    }
    
    public void addError(String error) {
        errors.add(error);
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
    
    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }
    
    public String getFirstError() {
        return errors.isEmpty() ? null : errors.get(0);
    }
    
    public String getAllErrors() {
        return String.join("; ", errors);
    }
}