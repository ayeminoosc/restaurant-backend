package com.acf.pos.restaurant.backend.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Entity representing a restaurant in the POS system
 * Contains basic restaurant information, settings, and configuration
 */
@DatabaseTable(tableName = "restaurant")
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

    // Getters and Setters
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }



    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getServiceChargePercentage() {
        return serviceChargePercentage;
    }

    public void setServiceChargePercentage(Double serviceChargePercentage) {
        this.serviceChargePercentage = serviceChargePercentage;
    }

    public Double getGratuityPercentage() {
        return gratuityPercentage;
    }

    public void setGratuityPercentage(Double gratuityPercentage) {
        this.gratuityPercentage = gratuityPercentage;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public String getTicketFooter() {
        return ticketFooter;
    }

    public void setTicketFooter(String ticketFooter) {
        this.ticketFooter = ticketFooter;
    }

    public boolean isPriceIncludesTax() {
        return priceIncludesTax;
    }

    public void setPriceIncludesTax(boolean priceIncludesTax) {
        this.priceIncludesTax = priceIncludesTax;
    }

    public boolean isAllowModifierMaxExceed() {
        return allowModifierMaxExceed;
    }

    public void setAllowModifierMaxExceed(boolean allowModifierMaxExceed) {
        this.allowModifierMaxExceed = allowModifierMaxExceed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public boolean isDeliveryEnabled() {
        return deliveryEnabled;
    }

    public void setDeliveryEnabled(boolean deliveryEnabled) {
        this.deliveryEnabled = deliveryEnabled;
    }

    public boolean isTakeoutEnabled() {
        return takeoutEnabled;
    }

    public void setTakeoutEnabled(boolean takeoutEnabled) {
        this.takeoutEnabled = takeoutEnabled;
    }

    public boolean isReservationEnabled() {
        return reservationEnabled;
    }

    public void setReservationEnabled(boolean reservationEnabled) {
        this.reservationEnabled = reservationEnabled;
    }
}
