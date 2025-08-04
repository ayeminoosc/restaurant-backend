package com.acf.pos.restaurant.backend.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String resourceType, String id) {
        super(resourceType + " with id '" + id + "' not found");
    }
}