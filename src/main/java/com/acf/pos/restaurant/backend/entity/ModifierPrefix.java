package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "modifier_prefix")
public class ModifierPrefix extends BaseEntity{
    
    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Modifier modifier;

    @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true)
    private Prefix prefix;

    public ModifierPrefix() {}

    public ModifierPrefix(Modifier modifier, Prefix prefix) {
        this.modifier = modifier;
        this.prefix = prefix;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix prefix) {
        this.prefix = prefix;
    }
}




