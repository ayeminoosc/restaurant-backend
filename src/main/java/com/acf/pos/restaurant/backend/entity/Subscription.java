package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "subscription")
@Data
public class Subscription extends BaseEntity {
    

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false, columnName = "organization_id")
    private Organization organization;

    @DatabaseField(canBeNull = false, columnName = "plan_name")
    private String planName;

    @DatabaseField(canBeNull = false, columnName = "status")
    private String status;

    @DatabaseField(columnName = "start_date")
    private Date startDate;

    @DatabaseField(columnName = "end_date")
    private Date endDate;

    @DatabaseField(columnName = "trial_end_date")
    private Date trialEndDate;
}
