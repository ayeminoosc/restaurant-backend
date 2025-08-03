package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@DatabaseTable(tableName = "restaurant")
@Data
public class Restaurant extends BaseEntity {

    

    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false, columnName = "organization_id")
    private Organization organization;

    @DatabaseField(columnName = "unique_id")
    private Integer uniqueId;

    

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "address_line1")
    private String addressLine1;

    @DatabaseField(columnName = "address_line2")
    private String addressLine2;

    @DatabaseField(columnName = "address_line3")
    private String addressLine3;

    @DatabaseField(columnName = "zip_code")
    private String zipCode;

    @DatabaseField(columnName = "telephone")
    private String telephone;

    @DatabaseField(columnName = "capacity")
    private Integer capacity;

    @DatabaseField(columnName = "tables")
    private Integer tables;

    @DatabaseField(columnName = "cname")
    private String currencyName;

    @DatabaseField(columnName = "csymbol")
    private String currencySymbol;

    @DatabaseField(columnName = "sc_percentage")
    private Double serviceChargePercentage;

    @DatabaseField(columnName = "gratuity_percentage")
    private Double gratuityPercentage;

    @DatabaseField(columnName = "ticket_footer")
    private String ticketFooter;

    @DatabaseField(columnName = "price_includes_tax")
    private boolean priceIncludesTax;

    @DatabaseField(columnName = "allow_modifier_max_exceed")
    private boolean allowModifierMaxExceed;
}
