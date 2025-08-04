package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@DatabaseTable(tableName = "menu_item")
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuItem extends ButtonAppearanceEntity {

    @DatabaseField(canBeNull = false, columnName = "item_code")
    private String itemCode;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "price")
    private Double price;

    @DatabaseField(foreign = true, canBeNull = true, columnName = "category_id")
    private Category category;

    // ModifierGroups will be loaded separately through service layer

    @DatabaseField(columnName = "is_available")
    private boolean available = true;

    @DatabaseField(columnName = "image_url")
    private String imageUrl;

    @DatabaseField(columnName = "preparation_time")
    private Integer preparationTimeMinutes;

    @DatabaseField(columnName = "calories")
    private Integer calories;

    @DatabaseField(columnName = "allergen_info")
    private String allergenInfo;

    @DatabaseField(columnName = "spice_level")
    private Integer spiceLevel; // 0-5 scale

    @DatabaseField(columnName = "is_vegetarian")
    private Boolean isVegetarian = false;

    @DatabaseField(columnName = "is_vegan")
    private Boolean isVegan = false;
}
