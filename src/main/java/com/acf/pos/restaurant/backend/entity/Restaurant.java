package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity representing a restaurant in the POS system
 * Contains basic restaurant information, settings, and configuration
 */
@DatabaseTable(tableName = "restaurant")
@Data
@EqualsAndHashCode(callSuper = true)
public class Restaurant extends BaseEntity {

    @DatabaseField(foreign = true, canBeNull = false, columnName = "organization_id")
    private Organization organization;

    @DatabaseField(columnName = "unique_id")
    private String uniqueId;

    @DatabaseField(canBeNull = false, columnName = "name")
    private String name;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "address_line1")
    private String addressLine1;

    @DatabaseField(columnName = "address_line2")
    private String addressLine2;

    @DatabaseField(columnName = "address_line3")
    private String addressLine3;

    @DatabaseField(columnName = "city")
    private String city;

    @DatabaseField(columnName = "state")
    private String state;

    @DatabaseField(columnName = "zip_code")
    private String zipCode;

    @DatabaseField(columnName = "country")
    private String country;

    @DatabaseField(columnName = "telephone")
    private String telephone;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "website")
    private String website;

    @DatabaseField(columnName = "capacity")
    private Integer capacity;

    @DatabaseField(columnName = "currency_name")
    private String currencyName;

    @DatabaseField(columnName = "currency_symbol")
    private String currencySymbol;

    @DatabaseField(columnName = "currency_code")
    private String currencyCode;

    @DatabaseField(columnName = "service_charge_percentage")
    private Double serviceChargePercentage;

    @DatabaseField(columnName = "gratuity_percentage")
    private Double gratuityPercentage;

    @DatabaseField(columnName = "tax_percentage")
    private Double taxPercentage;

    @DatabaseField(columnName = "ticket_footer")
    private String ticketFooter;

    @DatabaseField(columnName = "price_includes_tax")
    private boolean priceIncludesTax = false;

    @DatabaseField(columnName = "allow_modifier_max_exceed")
    private boolean allowModifierMaxExceed = false;

    @DatabaseField(columnName = "is_active")
    private boolean isActive = true;

    @DatabaseField(columnName = "timezone")
    private String timezone;

    @DatabaseField(columnName = "opening_time")
    private String openingTime;

    @DatabaseField(columnName = "closing_time")
    private String closingTime;

    @DatabaseField(columnName = "logo_url")
    private String logoUrl;

    @DatabaseField(columnName = "cuisine_type")
    private String cuisineType;

    @DatabaseField(columnName = "delivery_enabled")
    private boolean deliveryEnabled = false;

    @DatabaseField(columnName = "takeout_enabled")
    private boolean takeoutEnabled = true;

    @DatabaseField(columnName = "reservation_enabled")
    private boolean reservationEnabled = false;

    // Constructors
    public Restaurant() {}

}
