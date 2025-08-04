package com.acf.pos.restaurant.backend.common;

/**
 * Portable logging interface that can be implemented for different platforms
 * - Spring Boot: SLF4J implementation
 * - Android: Android Log implementation
 * - Console: System.out implementation
 */
public interface Logger {
    
    void debug(String message);
    void debug(String message, Object... args);
    
    void info(String message);
    void info(String message, Object... args);
    
    void warn(String message);
    void warn(String message, Object... args);
    
    void error(String message);
    void error(String message, Object... args);
    void error(String message, Throwable throwable);
}