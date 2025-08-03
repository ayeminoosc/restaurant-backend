package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.entity.User;
import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    private Dao<User, String> userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validateCredentials(String email, String phoneNumber, String password) throws SQLException {
        User user = userDao.queryBuilder().where().eq("email", email).queryForFirst();
        if( user == null && phoneNumber != null) {
            user = userDao.queryBuilder().where().eq("phone_no", phoneNumber).queryForFirst();
        }
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}