package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NameableEntity extends BaseEntity {

    @DatabaseField(canBeNull = false, columnName = "name")
    private String name;

    @DatabaseField(canBeNull = true, columnName = "bilingual_name")
    private String bilingualName; // Bilingual name for the prefix

}
