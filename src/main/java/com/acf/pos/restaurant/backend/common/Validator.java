package com.acf.pos.restaurant.backend.common;

/**
 * Portable validation utility
 */
public class Validator {
    
    public static ValidationResult validate(Object object) {
        ValidationResult result = new ValidationResult();
        
        if (object == null) {
            result.addError("Object cannot be null");
            return result;
        }
        
        // Add more validation logic as needed
        return result;
    }

    //generic validation methods for isBlank
    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Simple regex for basic email validation
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static ValidationResult validateNotNull(Object value, String fieldName) {
        ValidationResult result = new ValidationResult();
        if (value == null) {
            result.addError(fieldName + " is required");
        }
        return result;
    }

    public static ValidationResult validateNotBlank(String value, String fieldName) {
        ValidationResult result = new ValidationResult();
        if (value == null || value.trim().isEmpty()) {
            result.addError(fieldName + " is required");
        }
        return result;
    }

    public static ValidationResult validateMaxLength(String value, int maxLength, String fieldName) {
        ValidationResult result = new ValidationResult();
        if (value != null && value.length() > maxLength) {
            result.addError(fieldName + " must not exceed " + maxLength + " characters");
        }
        return result;
    }

    public static ValidationResult validateMinLength(String value, int minLength, String fieldName) {
        ValidationResult result = new ValidationResult();
        if (value != null && value.length() < minLength) {
            result.addError(fieldName + " must be at least " + minLength + " characters");
        }
        return result;
    }

    
    public static void validateNotNull(Object value, String fieldName, ValidationResult result) {
        if (value == null) {
            result.addError(fieldName + " is required");
        }
    }
    
    public static void validateNotBlank(String value, String fieldName, ValidationResult result) {
        if (value == null || value.trim().isEmpty()) {
            result.addError(fieldName + " is required");
        }
    }
    
    public static void validateMaxLength(String value, int maxLength, String fieldName, ValidationResult result) {
        if (value != null && value.length() > maxLength) {
            result.addError(fieldName + " must not exceed " + maxLength + " characters");
        }
    }
    
    public static void validateMinLength(String value, int minLength, String fieldName, ValidationResult result) {
        if (value != null && value.length() < minLength) {
            result.addError(fieldName + " must be at least " + minLength + " characters");
        }
    }
}