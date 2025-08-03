package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "shift")
@Data
public class Shift extends BaseEntity {
    

    @DatabaseField(unique = true, columnName = "name")
    private String name;

    @DatabaseField(columnName = "start_time")
    private Date startTime;

    @DatabaseField(columnName = "end_time")
    private Date endTime;

    @DatabaseField(columnName = "shift_len")
    private Long shiftLength;

    @DatabaseField(foreign = true, columnName = "restaurant_id")
    private Restaurant restaurant;
}
