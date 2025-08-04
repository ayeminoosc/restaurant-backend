package com.acf.pos.restaurant.backend.common;

/**
 * Factory for creating platform-specific logger instances
 */
public class LoggerFactory {
    
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getSimpleName());
    }
    
    public static Logger getLogger(String name) {
        // This will be implemented differently for each platform
        // Spring Boot will return SLF4J wrapper
        // Android will return Android Log wrapper
        return new DefaultLogger(name);
    }
    
    /**
     * Default console-based logger implementation
     */
    private static class DefaultLogger implements Logger {
        private final String name;
        
        public DefaultLogger(String name) {
            this.name = name;
        }
        
        @Override
        public void debug(String message) {
            System.out.println("[DEBUG] " + name + ": " + message);
        }
        
        @Override
        public void debug(String message, Object... args) {
            debug(String.format(message, args));
        }
        
        @Override
        public void info(String message) {
            System.out.println("[INFO] " + name + ": " + message);
        }
        
        @Override
        public void info(String message, Object... args) {
            info(String.format(message, args));
        }
        
        @Override
        public void warn(String message) {
            System.out.println("[WARN] " + name + ": " + message);
        }
        
        @Override
        public void warn(String message, Object... args) {
            warn(String.format(message, args));
        }
        
        @Override
        public void error(String message) {
            System.err.println("[ERROR] " + name + ": " + message);
        }
        
        @Override
        public void error(String message, Object... args) {
            error(String.format(message, args));
        }
        
        @Override
        public void error(String message, Throwable throwable) {
            System.err.println("[ERROR] " + name + ": " + message);
            if (throwable != null) {
                throwable.printStackTrace();
            }
        }
    }
}