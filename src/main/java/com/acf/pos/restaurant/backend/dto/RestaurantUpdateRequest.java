package com.acf.pos.restaurant.backend.dto;

import com.acf.pos.restaurant.backend.common.ValidationResult;
import com.acf.pos.restaurant.backend.common.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RestaurantUpdateRequest {

    @JsonProperty("unique_id")
    private String uniqueId;

    private String name;

    private String description;

    @JsonProperty("address_line1")
    private String addressLine1;

    @JsonProperty("address_line2")
    private String addressLine2;

    @JsonProperty("address_line3")
    private String addressLine3;

    private String city;

    private String state;

    @JsonProperty("zip_code")
    private String zipCode;

    private String country;

    private String telephone;

    private String email;

    private String website;

    private Integer capacity;

    @JsonProperty("currency_name")
    private String currencyName;

    @JsonProperty("currency_symbol")
    private String currencySymbol;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("service_charge_percentage")
    private Double serviceChargePercentage;

    @JsonProperty("gratuity_percentage")
    private Double gratuityPercentage;

    @JsonProperty("tax_percentage")
    private Double taxPercentage;

    @JsonProperty("ticket_footer")
    private String ticketFooter;

    @JsonProperty("price_includes_tax")
    private Boolean priceIncludesTax;

    @JsonProperty("allow_modifier_max_exceed")
    private Boolean allowModifierMaxExceed;

    @JsonProperty("is_active")
    private Boolean isActive;

    private String timezone;

    @JsonProperty("opening_time")
    private String openingTime;

    @JsonProperty("closing_time")
    private String closingTime;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("cuisine_type")
    private String cuisineType;

    @JsonProperty("delivery_enabled")
    private Boolean deliveryEnabled;

    @JsonProperty("takeout_enabled")
    private Boolean takeoutEnabled;

    @JsonProperty("reservation_enabled")
    private Boolean reservationEnabled;

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        if (name != null && Validator.isBlank(name)) {
            result.addError("Restaurant name cannot be empty");
        }

        if (name != null && name.length() > 255) {
            result.addError("Restaurant name cannot exceed 255 characters");
        }

        if (email != null && !Validator.isValidEmail(email)) {
            result.addError("Invalid email format");
        }

        if (currencyCode != null && currencyCode.length() > 3) {
            result.addError("Currency code cannot exceed 3 characters");
        }

        if (serviceChargePercentage != null && (serviceChargePercentage < 0 || serviceChargePercentage > 100)) {
            result.addError("Service charge percentage must be between 0 and 100");
        }

        if (gratuityPercentage != null && (gratuityPercentage < 0 || gratuityPercentage > 100)) {
            result.addError("Gratuity percentage must be between 0 and 100");
        }

        if (taxPercentage != null && (taxPercentage < 0 || taxPercentage > 100)) {
            result.addError("Tax percentage must be between 0 and 100");
        }

        if (capacity != null && capacity < 0) {
            result.addError("Capacity cannot be negative");
        }

        return result;
    }
}