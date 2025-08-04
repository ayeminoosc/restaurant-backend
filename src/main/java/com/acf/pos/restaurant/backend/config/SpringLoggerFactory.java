package com.acf.pos.restaurant.backend.config;

import com.acf.pos.restaurant.backend.common.Logger;
import org.slf4j.LoggerFactory;

/**
 * Spring Boot implementation of Logger using SLF4J
 */
public class SpringLoggerFactory {
    
    public static Logger getLogger(Class<?> clazz) {
        return new SLF4JLogger(LoggerFactory.getLogger(clazz));
    }
    
    public static Logger getLogger(String name) {
        return new SLF4JLogger(LoggerFactory.getLogger(name));
    }
    
    private static class SLF4JLogger implements Logger {
        private final org.slf4j.Logger slf4jLogger;
        
        public SLF4JLogger(org.slf4j.Logger slf4jLogger) {
            this.slf4jLogger = slf4jLogger;
        }
        
        @Override
        public void debug(String message) {
            slf4jLogger.debug(message);
        }
        
        @Override
        public void debug(String message, Object... args) {
            slf4jLogger.debug(message, args);
        }
        
        @Override
        public void info(String message) {
            slf4jLogger.info(message);
        }
        
        @Override
        public void info(String message, Object... args) {
            slf4jLogger.info(message, args);
        }
        
        @Override
        public void warn(String message) {
            slf4jLogger.warn(message);
        }
        
        @Override
        public void warn(String message, Object... args) {
            slf4jLogger.warn(message, args);
        }
        
        @Override
        public void error(String message) {
            slf4jLogger.error(message);
        }
        
        @Override
        public void error(String message, Object... args) {
            slf4jLogger.error(message, args);
        }
        
        @Override
        public void error(String message, Throwable throwable) {
            slf4jLogger.error(message, throwable);
        }
    }
}