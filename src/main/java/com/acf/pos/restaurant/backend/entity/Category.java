package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "category")
@Data
public class Category extends BaseEntity {

    @DatabaseField(foreign = true, canBeNull = false, columnName = "restaurant_id")
    private Restaurant restaurant;

    @DatabaseField(foreign = true, columnName = "parent_category_id")
    private Category parentCategory;

    @DatabaseField(canBeNull = false, columnName = "name")
    private String name;

    @DatabaseField(columnName = "bilingual_name")
    private String bilingualName;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "display_order")
    private Integer displayOrder;

    @DatabaseField(columnName = "is_active")
    private boolean isActive = true;

    @DatabaseField(columnName = "color_code")
    private String colorCode;

    @DatabaseField(columnName = "icon_url")
    private String iconUrl;

    @DatabaseField(columnName = "tax_applicable")
    private boolean taxApplicable = true;
}