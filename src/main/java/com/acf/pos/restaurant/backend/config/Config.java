package com.acf.pos.restaurant.backend.config;

import com.acf.pos.restaurant.backend.entity.RefreshToken;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
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
    public Dao<RefreshToken, String> refreshTokenDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, RefreshToken.class);
    }

    @Bean
    public Dao<User, Integer> userDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, User.class);
    }

    @Bean
    public Dao<UserType, Integer> userTypeDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, UserType.class);
    }

    @Bean
    public Dao<Shift, Integer> shiftDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Shift.class);
    }

    @Bean
    public Dao<Terminal, Integer> terminalDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Terminal.class);
    }

}
