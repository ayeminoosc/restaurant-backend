package com.acf.pos.restaurant.backend.entity;


import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@DatabaseTable(tableName = "modifier_group")
@Data
@EqualsAndHashCode(callSuper = true)
public class ModifierGroup extends ButtonAppearanceEntity{

    @DatabaseField(canBeNull = false, columnName = "min_selection", defaultValue = "0")
    private int minSelection;

    @DatabaseField(canBeNull = false, columnName = "max_selection", defaultValue = "1")
    private int maxSelection;
    @DatabaseField(canBeNull = false, columnName = "multi_select")
    private boolean multipleSelection = false;

    @DatabaseField(canBeNull = false, columnName = "required")
    private boolean required = false;

    @ForeignCollectionField(eager = false)
    private ForeignCollection<Modifier> modifiers;

    // MenuItems will be loaded separately through service layer
    @DatabaseField(columnName = "display_order")
    private Integer displayOrder;

    @DatabaseField(columnName = "is_active")
    private Boolean isActive = true;
}
