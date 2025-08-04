package com.acf.pos.restaurant.backend.common;

import java.sql.SQLException;

/**
 * Portable transaction callback interface
 */
@FunctionalInterface
public interface TransactionCallback<T> {
    T execute() throws SQLException;
}