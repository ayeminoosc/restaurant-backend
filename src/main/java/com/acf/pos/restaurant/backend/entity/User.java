package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import java.util.Date;

@DatabaseTable(tableName = "users")
@Data
public class User {

    @DatabaseField(generatedId = true, columnName = "auto_id")
    private Integer autoId;

    @DatabaseField(unique = true, columnName = "user_id")
    private Integer userId;

    @DatabaseField(canBeNull = false, columnName = "user_pass")
    private String password;

    @DatabaseField(columnName = "first_name")
    private String firstName;

    @DatabaseField(columnName = "last_name")
    private String lastName;

    @DatabaseField
    private String ssn;

    @DatabaseField(columnName = "cost_per_hour")
    private Double costPerHour;

    @DatabaseField(columnName = "clocked_in")
    private boolean clockedIn;

    @DatabaseField(columnName = "last_clock_in_time")
    private Date lastClockInTime;

    @DatabaseField(columnName = "last_clock_out_time")
    private Date lastClockOutTime;

    @DatabaseField(columnName = "phone_no")
    private String phoneNo;

    @DatabaseField(columnName = "is_driver")
    private boolean isDriver;

    @DatabaseField(columnName = "available_for_delivery")
    private boolean availableForDelivery;

    @DatabaseField
    private boolean active;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "shift_id")
    private Shift shift;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "currentterminal")
    private Terminal currentTerminal;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "n_user_type")
    private UserType userType;
}
