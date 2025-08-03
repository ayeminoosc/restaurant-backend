package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import java.util.Date;

@DatabaseTable(tableName = "shift")
@Data
public class Shift {
    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(unique = true)
    private String name;

    @DatabaseField
    private Date startTime;

    @DatabaseField
    private Date endTime;

    @DatabaseField(columnName = "shift_len")
    private Long shiftLength;
}
