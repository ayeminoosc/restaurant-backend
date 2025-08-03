package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "terminal")
@Data
public class Terminal extends BaseEntity {
    

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "terminal_key")
    private String terminalKey;

    @DatabaseField(columnName = "opening_balance")
    private Double openingBalance;

    @DatabaseField(columnName = "current_balance")
    private Double currentBalance;

    @DatabaseField(columnName = "has_cash_drawer")
    private boolean hasCashDrawer;

    @DatabaseField(columnName = "in_use")
    private boolean inUse;

    @DatabaseField(columnName = "active")
    private boolean active;

    @DatabaseField(columnName = "location")
    private String location;

    @DatabaseField(columnName = "floor_id")
    private Integer floorId;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "assigned_user")
    private User assignedUser;

    @DatabaseField(foreign = true, columnName = "restaurant_id")
    private Restaurant restaurant;
}
