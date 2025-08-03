package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.entity.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    private Dao<User, Integer> userDao;

    public boolean validateCredentials(String username, String password) throws SQLException {
        User user = userDao.queryBuilder().where().eq("phoneNo", username).queryForFirst();
        return user != null && user.getPassword().equals(password);
    }
}