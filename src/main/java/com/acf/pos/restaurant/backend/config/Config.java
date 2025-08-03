package com.acf.pos.restaurant.backend.config;

import com.acf.pos.restaurant.backend.entity.RefreshToken;
import com.acf.pos.restaurant.backend.entity.Organization;
import com.acf.pos.restaurant.backend.entity.Restaurant;
import com.acf.pos.restaurant.backend.entity.Subscription;
import com.acf.pos.restaurant.backend.entity.User;
import com.acf.pos.restaurant.backend.entity.UserType;
import com.acf.pos.restaurant.backend.entity.Shift;
import com.acf.pos.restaurant.backend.entity.Terminal;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class Config {
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username:}")
    private String username;

    @Value("${spring.datasource.password:}")
    private String password;

    @Bean
    public ConnectionSource connectionSource() throws SQLException {
        if (!username.isEmpty()) {
            return new JdbcConnectionSource(databaseUrl, username, password);
        }
        return new JdbcConnectionSource(databaseUrl);
    }

    @Bean
    public TransactionManager transactionManager(ConnectionSource connectionSource) throws SQLException {
        return new TransactionManager(connectionSource());
    }
    @Bean
    public Dao<RefreshToken, String> refreshTokenDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, RefreshToken.class);
    }

    @Bean
    public Dao<User, String> userDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, User.class);
    }

    @Bean
    public Dao<UserType, String> userTypeDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, UserType.class);
    }

    @Bean
    public Dao<Shift, String> shiftDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Shift.class);
    }

    @Bean
    public Dao<Terminal, String> terminalDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Terminal.class);
    }

    @Bean
    public Dao<Organization, String> organizationDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Organization.class);
    }

    @Bean
    public Dao<Subscription, String> subscriptionDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Subscription.class);
    }

    @Bean
    public Dao<Restaurant, String> restaurantDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Restaurant.class);
    }

}