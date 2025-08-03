package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "refresh_token")
@Data
public class RefreshToken extends BaseEntity {
    

    @DatabaseField(canBeNull = false, columnName = "user_id")
    private String userId;

    @DatabaseField(columnName = "device_name")
    private String deviceName;

    @DatabaseField(columnName = "ip_address")
    private String ipAddress;

    @DatabaseField(columnName = "user_agent")
    private String userAgent;

    

    @DatabaseField(canBeNull = false, columnName = "expires_at")
    private Date expiresAt;

    @DatabaseField
    private boolean revoked;

    @DatabaseField(columnName = "last_used_at")
    private Date lastUsedAt;

    @DatabaseField
    private String location;

    // Getters and setters
}
