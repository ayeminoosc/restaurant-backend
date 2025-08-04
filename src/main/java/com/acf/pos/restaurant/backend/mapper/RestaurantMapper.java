package com.acf.pos.restaurant.backend.mapper;

import com.acf.pos.restaurant.backend.dto.RestaurantCreateRequest;
import com.acf.pos.restaurant.backend.dto.RestaurantResponse;
import com.acf.pos.restaurant.backend.dto.RestaurantUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Organization;
import com.acf.pos.restaurant.backend.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantMapper {

    public Restaurant toEntity(RestaurantCreateRequest request) {
        if (request == null) {
            return null;
        }

        Restaurant restaurant = new Restaurant();
        
        Organization organization = new Organization();
        organization.setId(request.getOrganizationId());
        restaurant.setOrganization(organization);

        restaurant.setUniqueId(request.getUniqueId());
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setAddressLine1(request.getAddressLine1());
        restaurant.setAddressLine2(request.getAddressLine2());
        restaurant.setAddressLine3(request.getAddressLine3());
        restaurant.setCity(request.getCity());
        restaurant.setState(request.getState());
        restaurant.setZipCode(request.getZipCode());
        restaurant.setCountry(request.getCountry());
        restaurant.setTelephone(request.getTelephone());
        restaurant.setEmail(request.getEmail());
        restaurant.setWebsite(request.getWebsite());
        restaurant.setCapacity(request.getCapacity());
        restaurant.setCurrencyName(request.getCurrencyName());
        restaurant.setCurrencySymbol(request.getCurrencySymbol());
        restaurant.setCurrencyCode(request.getCurrencyCode());
        restaurant.setServiceChargePercentage(request.getServiceChargePercentage());
        restaurant.setGratuityPercentage(request.getGratuityPercentage());
        restaurant.setTaxPercentage(request.getTaxPercentage());
        restaurant.setTicketFooter(request.getTicketFooter());
        restaurant.setPriceIncludesTax(request.getPriceIncludesTax() != null ? request.getPriceIncludesTax() : false);
        restaurant.setAllowModifierMaxExceed(request.getAllowModifierMaxExceed() != null ? request.getAllowModifierMaxExceed() : false);
        restaurant.setActive(request.getIsActive() != null ? request.getIsActive() : true);
        restaurant.setTimezone(request.getTimezone());
        restaurant.setOpeningTime(request.getOpeningTime());
        restaurant.setClosingTime(request.getClosingTime());
        restaurant.setLogoUrl(request.getLogoUrl());
        restaurant.setCuisineType(request.getCuisineType());
        restaurant.setDeliveryEnabled(request.getDeliveryEnabled() != null ? request.getDeliveryEnabled() : false);
        restaurant.setTakeoutEnabled(request.getTakeoutEnabled() != null ? request.getTakeoutEnabled() : true);
        restaurant.setReservationEnabled(request.getReservationEnabled() != null ? request.getReservationEnabled() : false);

        return restaurant;
    }

    public void updateEntity(Restaurant restaurant, RestaurantUpdateRequest request) {
        if (request == null || restaurant == null) {
            return;
        }

        if (request.getUniqueId() != null) {
            restaurant.setUniqueId(request.getUniqueId());
        }
        if (request.getName() != null) {
            restaurant.setName(request.getName());
        }
        if (request.getDescription() != null) {
            restaurant.setDescription(request.getDescription());
        }
        if (request.getAddressLine1() != null) {
            restaurant.setAddressLine1(request.getAddressLine1());
        }
        if (request.getAddressLine2() != null) {
            restaurant.setAddressLine2(request.getAddressLine2());
        }
        if (request.getAddressLine3() != null) {
            restaurant.setAddressLine3(request.getAddressLine3());
        }
        if (request.getCity() != null) {
            restaurant.setCity(request.getCity());
        }
        if (request.getState() != null) {
            restaurant.setState(request.getState());
        }
        if (request.getZipCode() != null) {
            restaurant.setZipCode(request.getZipCode());
        }
        if (request.getCountry() != null) {
            restaurant.setCountry(request.getCountry());
        }
        if (request.getTelephone() != null) {
            restaurant.setTelephone(request.getTelephone());
        }
        if (request.getEmail() != null) {
            restaurant.setEmail(request.getEmail());
        }
        if (request.getWebsite() != null) {
            restaurant.setWebsite(request.getWebsite());
        }
        if (request.getCapacity() != null) {
            restaurant.setCapacity(request.getCapacity());
        }
        if (request.getCurrencyName() != null) {
            restaurant.setCurrencyName(request.getCurrencyName());
        }
        if (request.getCurrencySymbol() != null) {
            restaurant.setCurrencySymbol(request.getCurrencySymbol());
        }
        if (request.getCurrencyCode() != null) {
            restaurant.setCurrencyCode(request.getCurrencyCode());
        }
        if (request.getServiceChargePercentage() != null) {
            restaurant.setServiceChargePercentage(request.getServiceChargePercentage());
        }
        if (request.getGratuityPercentage() != null) {
            restaurant.setGratuityPercentage(request.getGratuityPercentage());
        }
        if (request.getTaxPercentage() != null) {
            restaurant.setTaxPercentage(request.getTaxPercentage());
        }
        if (request.getTicketFooter() != null) {
            restaurant.setTicketFooter(request.getTicketFooter());
        }
        if (request.getPriceIncludesTax() != null) {
            restaurant.setPriceIncludesTax(request.getPriceIncludesTax());
        }
        if (request.getAllowModifierMaxExceed() != null) {
            restaurant.setAllowModifierMaxExceed(request.getAllowModifierMaxExceed());
        }
        if (request.getIsActive() != null) {
            restaurant.setActive(request.getIsActive());
        }
        if (request.getTimezone() != null) {
            restaurant.setTimezone(request.getTimezone());
        }
        if (request.getOpeningTime() != null) {
            restaurant.setOpeningTime(request.getOpeningTime());
        }
        if (request.getClosingTime() != null) {
            restaurant.setClosingTime(request.getClosingTime());
        }
        if (request.getLogoUrl() != null) {
            restaurant.setLogoUrl(request.getLogoUrl());
        }
        if (request.getCuisineType() != null) {
            restaurant.setCuisineType(request.getCuisineType());
        }
        if (request.getDeliveryEnabled() != null) {
            restaurant.setDeliveryEnabled(request.getDeliveryEnabled());
        }
        if (request.getTakeoutEnabled() != null) {
            restaurant.setTakeoutEnabled(request.getTakeoutEnabled());
        }
        if (request.getReservationEnabled() != null) {
            restaurant.setReservationEnabled(request.getReservationEnabled());
        }
    }

    public RestaurantResponse toResponse(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setOrganizationId(restaurant.getOrganization() != null ? restaurant.getOrganization().getId() : null);
        response.setUniqueId(restaurant.getUniqueId());
        response.setName(restaurant.getName());
        response.setDescription(restaurant.getDescription());
        response.setAddressLine1(restaurant.getAddressLine1());
        response.setAddressLine2(restaurant.getAddressLine2());
        response.setAddressLine3(restaurant.getAddressLine3());
        response.setCity(restaurant.getCity());
        response.setState(restaurant.getState());
        response.setZipCode(restaurant.getZipCode());
        response.setCountry(restaurant.getCountry());
        response.setTelephone(restaurant.getTelephone());
        response.setEmail(restaurant.getEmail());
        response.setWebsite(restaurant.getWebsite());
        response.setCapacity(restaurant.getCapacity());
        response.setCurrencyName(restaurant.getCurrencyName());
        response.setCurrencySymbol(restaurant.getCurrencySymbol());
        response.setCurrencyCode(restaurant.getCurrencyCode());
        response.setServiceChargePercentage(restaurant.getServiceChargePercentage());
        response.setGratuityPercentage(restaurant.getGratuityPercentage());
        response.setTaxPercentage(restaurant.getTaxPercentage());
        response.setTicketFooter(restaurant.getTicketFooter());
        response.setPriceIncludesTax(restaurant.isPriceIncludesTax());
        response.setAllowModifierMaxExceed(restaurant.isAllowModifierMaxExceed());
        response.setIsActive(restaurant.isActive());
        response.setTimezone(restaurant.getTimezone());
        response.setOpeningTime(restaurant.getOpeningTime());
        response.setClosingTime(restaurant.getClosingTime());
        response.setLogoUrl(restaurant.getLogoUrl());
        response.setCuisineType(restaurant.getCuisineType());
        response.setDeliveryEnabled(restaurant.isDeliveryEnabled());
        response.setTakeoutEnabled(restaurant.isTakeoutEnabled());
        response.setReservationEnabled(restaurant.isReservationEnabled());

        if (restaurant.getCreatedAt() != null) {
            response.setCreatedAt(LocalDateTime.ofInstant(
                restaurant.getCreatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }
        
        if (restaurant.getUpdatedAt() != null) {
            response.setUpdatedAt(LocalDateTime.ofInstant(
                restaurant.getUpdatedAt().toInstant(), 
                ZoneId.systemDefault()
            ));
        }

        return response;
    }

    public List<RestaurantResponse> toResponseList(List<Restaurant> restaurants) {
        if (restaurants == null) {
            return null;
        }
        
        List<RestaurantResponse> responses = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            responses.add(toResponse(restaurant));
        }
        return responses;
    }
}