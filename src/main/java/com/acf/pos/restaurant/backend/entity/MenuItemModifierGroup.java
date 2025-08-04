package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "menu_item_modifier_group")
@Data

public class MenuItemModifierGroup extends BaseEntity {

    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true, columnName = "menu_item_id")
    private MenuItem menuItem;

    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true, columnName = "modifier_group_id")
    private ModifierGroup modifierGroup;

    @DatabaseField(columnName = "display_order")
    private Integer displayOrder;

    public MenuItemModifierGroup() {}

    public MenuItemModifierGroup(MenuItem menuItem, ModifierGroup modifierGroup) {
        this.menuItem = menuItem;
        this.modifierGroup = modifierGroup;
    }
}