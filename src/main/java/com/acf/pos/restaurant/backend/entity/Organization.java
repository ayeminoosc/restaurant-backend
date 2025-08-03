package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "organization")
@Data
public class Organization extends BaseEntity {
    

    @DatabaseField(canBeNull = false, unique = true)
    private String name;
}
