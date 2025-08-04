package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@DatabaseTable(tableName = "modifier")
@Data
@EqualsAndHashCode(callSuper = true)
public class Modifier extends NameableEntity{
    @DatabaseField(canBeNull = false, columnName = "price", defaultValue = "0.0")
    private Double price;

    @DatabaseField(foreign = true, foreignAutoRefresh = false , columnName = "modifier_group_id")
    private ModifierGroup modifierGroup;

    @ForeignCollectionField(eager = false)
    private ForeignCollection<ModifierPrefix> modifierPrefixes;

    @DatabaseField(columnName = "display_order")
    private Integer displayOrder;

    @DatabaseField(columnName = "is_active")
    private Boolean isActive = true;

    @DatabaseField(columnName = "is_default")
    private Boolean isDefault = false;
}
