package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@DatabaseTable(tableName = "user_type")
@Data
public class UserType {
    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "p_name")
    private String name;
}
