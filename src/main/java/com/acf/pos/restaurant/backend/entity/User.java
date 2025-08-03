package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "user")
@Data
public class User extends BaseEntity {

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false, columnName = "organization_id")
    private Organization organization;

    @DatabaseField(foreign = true, columnName = "restaurant_id")
    private Restaurant restaurant;

    @DatabaseField(columnName = "is_owner")
    private boolean isOwner;

    @DatabaseField(canBeNull = false, columnName = "user_pass")
    private String password;

    @DatabaseField(columnName = "first_name")
    private String firstName;

    @DatabaseField(columnName = "last_name")
    private String lastName;

    @DatabaseField(columnName = "ssn")
    private String ssn;

    @DatabaseField(columnName = "email", unique = true, canBeNull = true)
    private String email;

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

    @DatabaseField(columnName = "active")
    private boolean active;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "shift_id")
    private Shift shift;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "currentterminal")
    private Terminal currentTerminal;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "n_user_type")
    private UserType userType;
}
