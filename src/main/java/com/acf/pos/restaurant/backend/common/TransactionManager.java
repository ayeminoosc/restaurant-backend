package com.acf.pos.restaurant.backend.common;

import java.sql.SQLException;

/**
 * Portable transaction manager interface
 * Can be implemented for different platforms:
 * - Spring Boot: Uses Spring's transaction management
 * - Android: Uses SQLite transaction management
 * - Standalone: Uses ORMLite transaction management
 */
public interface TransactionManager {
    
    /**
     * Execute a callback within a transaction
     * @param callback The operation to execute
     * @return The result of the callback
     * @throws SQLException if the operation fails
     */
    <T> T executeInTransaction(TransactionCallback<T> callback) throws SQLException;
}