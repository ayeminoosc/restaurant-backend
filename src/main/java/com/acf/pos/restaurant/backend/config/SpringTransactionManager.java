package com.acf.pos.restaurant.backend.config;

import com.acf.pos.restaurant.backend.common.TransactionCallback;
import com.acf.pos.restaurant.backend.common.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Spring Boot implementation of TransactionManager using ORMLite
 */
@Component
public class SpringTransactionManager implements TransactionManager {

    @Autowired
    private ConnectionSource connectionSource;

    @Autowired
    private com.j256.ormlite.misc.TransactionManager ORMLiteTransactionManager;

    @Override
    public <T> T executeInTransaction(TransactionCallback<T> callback) throws SQLException {
        return ORMLiteTransactionManager.callInTransaction(connectionSource, callback::execute);
    }
}