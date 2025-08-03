package com.acf.pos.restaurant.backend.service;

import com.acf.pos.restaurant.backend.entity.Organization;
import com.acf.pos.restaurant.backend.entity.Subscription;
import com.acf.pos.restaurant.backend.entity.User;
import com.acf.pos.restaurant.backend.pojo.RegistrationRequest;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;

@Service
public class RegistrationService {

    @Autowired
    private Dao<Organization, String> organizationDao;

    @Autowired
    private Dao<User, String> userDao;

    @Autowired
    private Dao<Subscription, String> subscriptionDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest request) throws SQLException {
        TransactionManager.callInTransaction(organizationDao.getConnectionSource(), () -> {
            // 1. Create the Organization
            Organization org = new Organization();
            org.setName(request.getOrganizationName());
            organizationDao.create(org);

            // 2. Create the User (Owner)
            User owner = new User();
            owner.setOrganization(org);
            owner.setEmail(request.getOwnerEmail());
            owner.setFirstName(request.getOwnerFirstName());
            owner.setLastName(request.getOwnerLastName());
            owner.setPhoneNo(request.getOwnerPhoneNo());
            owner.setPassword(passwordEncoder.encode(request.getPassword()));
            owner.setOwner(true);
            owner.setActive(true);
            userDao.create(owner);

            // 3. Create a default Subscription
            Subscription subscription = new Subscription();
            subscription.setOrganization(org);
            subscription.setPlanName("Trial");
            subscription.setStatus("Active");
            subscription.setStartDate(new Date());
            subscription.setTrialEndDate(new Date(System.currentTimeMillis() + 14L * 86400000)); // 14-day trial
            subscriptionDao.create(subscription);
            return null;
        });
    }
}
