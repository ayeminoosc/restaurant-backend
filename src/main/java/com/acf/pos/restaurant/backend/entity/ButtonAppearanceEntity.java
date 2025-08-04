package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ButtonAppearanceEntity extends NameableEntity {
    @DatabaseField(canBeNull = true, columnName = "color_code")
    private String colorCode;

    @DatabaseField(canBeNull = true, columnName = "icon_url")
    private String iconUrl;

    @DatabaseField(columnName = "display_order")
    private Integer displayOrder;
}
