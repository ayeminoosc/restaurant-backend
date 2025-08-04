package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode
public abstract class BaseEntity {

    @DatabaseField(id = true, canBeNull = false)
    private String id;

    @DatabaseField(canBeNull = false, columnName = "created_at")
    private Date createdAt;

    @DatabaseField(canBeNull = false, columnName = "updated_at")
    private Date updatedAt;

    @DatabaseField(columnName = "last_sync_time")
    private Date lastSyncTime;

    @DatabaseField(defaultValue = "false", columnName = "is_dirty")
    private boolean isDirty;

    @DatabaseField(defaultValue = "false", columnName = "deleted")
    private boolean deleted;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}
