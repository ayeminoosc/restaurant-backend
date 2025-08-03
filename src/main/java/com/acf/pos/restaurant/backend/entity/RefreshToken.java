package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import java.util.Date;

@DatabaseTable(tableName = "refresh_token")
@Data
public class RefreshToken {
    @DatabaseField(id = true)
    private String id;

    @DatabaseField(canBeNull = false)
    private String userId;

    @DatabaseField
    private String deviceName;

    @DatabaseField
    private String ipAddress;

    @DatabaseField
    private String userAgent;

    @DatabaseField(canBeNull = false)
    private Date createdAt;

    @DatabaseField(canBeNull = false)
    private Date expiresAt;

    @DatabaseField
    private boolean revoked;

    @DatabaseField
    private Date lastUsedAt;

    @DatabaseField
    private String location;

    // Getters and setters
}
