package com.acf.pos.restaurant.backend.entity;


import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@DatabaseTable(tableName = "prefix")
@Data
@EqualsAndHashCode(callSuper = true)
public class Prefix extends ButtonAppearanceEntity {

}
