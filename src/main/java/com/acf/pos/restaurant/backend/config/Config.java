package com.acf.pos.restaurant.backend.config;

import com.acf.pos.restaurant.backend.entity.RefreshToken;
import com.acf.pos.restaurant.backend.entity.Organization;
import com.acf.pos.restaurant.backend.entity.Restaurant;
import com.acf.pos.restaurant.backend.entity.Subscription;
import com.acf.pos.restaurant.backend.entity.User;
import com.acf.pos.restaurant.backend.entity.UserType;
import com.acf.pos.restaurant.backend.entity.Shift;
import com.acf.pos.restaurant.backend.entity.Terminal;
import com.acf.pos.restaurant.backend.entity.Category;
import com.acf.pos.restaurant.backend.entity.FloorPlan;
import com.acf.pos.restaurant.backend.entity.RestaurantTable;
import com.acf.pos.restaurant.backend.entity.MenuItem;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;
import com.acf.pos.restaurant.backend.entity.Modifier;
import com.acf.pos.restaurant.backend.entity.Prefix;
import com.acf.pos.restaurant.backend.entity.MenuItemModifierGroup;
import com.acf.pos.restaurant.backend.service.CategoryService;
import com.acf.pos.restaurant.backend.service.RestaurantService;
import com.acf.pos.restaurant.backend.service.MenuItemService;
import com.acf.pos.restaurant.backend.service.ModifierGroupService;
import com.acf.pos.restaurant.backend.service.ModifierService;
import com.acf.pos.restaurant.backend.service.PrefixService;
import com.acf.pos.restaurant.backend.mapper.CategoryMapper;
import com.acf.pos.restaurant.backend.mapper.RestaurantMapper;
import com.acf.pos.restaurant.backend.mapper.MenuItemMapper;
import com.acf.pos.restaurant.backend.mapper.ModifierGroupMapper;
import com.acf.pos.restaurant.backend.mapper.ModifierMapper;
import com.acf.pos.restaurant.backend.mapper.PrefixMapper;
import com.acf.pos.restaurant.backend.common.TransactionManager;
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
    public com.j256.ormlite.misc.TransactionManager transactionManager(ConnectionSource connectionSource) throws SQLException {
        return new com.j256.ormlite.misc.TransactionManager(connectionSource());
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

    @Bean
    public Dao<Category, String> categoryDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Category.class);
    }

    @Bean
    public Dao<FloorPlan, String> floorPlanDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, FloorPlan.class);
    }

    @Bean
    public Dao<RestaurantTable, String> restaurantTableDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, RestaurantTable.class);
    }

    @Bean
    public Dao<MenuItem, String> menuItemDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, MenuItem.class);
    }

    @Bean
    public Dao<ModifierGroup, String> modifierGroupDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, ModifierGroup.class);
    }

    @Bean
    public Dao<Modifier, String> modifierDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Modifier.class);
    }

    @Bean
    public Dao<Prefix, String> prefixDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, Prefix.class);
    }

    @Bean
    public Dao<MenuItemModifierGroup, String> menuItemModifierGroupDao(ConnectionSource connectionSource) throws SQLException {
        return DaoManager.createDao(connectionSource, MenuItemModifierGroup.class);
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public RestaurantMapper restaurantMapper() {
        return new RestaurantMapper();
    }

    @Bean
    public PrefixMapper prefixMapper() {
        return new PrefixMapper();
    }

    @Bean
    public ModifierMapper modifierMapper(PrefixMapper prefixMapper) {
        return new ModifierMapper(prefixMapper);
    }

    @Bean
    public ModifierGroupMapper modifierGroupMapper(ModifierMapper modifierMapper) {
        return new ModifierGroupMapper(modifierMapper);
    }

    @Bean
    public MenuItemMapper menuItemMapper() {
        return new MenuItemMapper();
    }

    @Bean
    public CategoryService categoryService(
            Dao<Category, String> categoryDao,
            Dao<Restaurant, String> restaurantDao,
            CategoryMapper categoryMapper,
            TransactionManager transactionManager) {
        return new CategoryService(categoryDao, restaurantDao, categoryMapper, transactionManager);
    }

    @Bean
    public RestaurantService restaurantService(
            Dao<Restaurant, String> restaurantDao,
            Dao<Organization, String> organizationDao,
            RestaurantMapper restaurantMapper,
            TransactionManager transactionManager) {
        return new RestaurantService(restaurantDao, organizationDao, restaurantMapper, transactionManager);
    }



    @Bean
    public ModifierGroupService modifierGroupService(
            Dao<ModifierGroup, String> modifierGroupDao,
            ModifierGroupMapper modifierGroupMapper,
            TransactionManager transactionManager) {
        return new ModifierGroupService(modifierGroupDao, modifierGroupMapper, transactionManager);
    }

    @Bean
    public ModifierService modifierService(
            Dao<Modifier, String> modifierDao,
            Dao<ModifierGroup, String> modifierGroupDao,
            ModifierMapper modifierMapper,
            TransactionManager transactionManager) {
        return new ModifierService(modifierDao, modifierGroupDao, modifierMapper, transactionManager);
    }

    @Bean
    public PrefixService prefixService(
            Dao<Prefix, String> prefixDao,
            PrefixMapper prefixMapper,
            TransactionManager transactionManager) {
        return new PrefixService(prefixDao, prefixMapper, transactionManager);
    }

}