package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.dto.RestaurantCreateRequest;
import com.acf.pos.restaurant.backend.dto.RestaurantResponse;
import com.acf.pos.restaurant.backend.dto.RestaurantUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Restaurant;
import com.acf.pos.restaurant.backend.mapper.RestaurantMapper;
import com.acf.pos.restaurant.backend.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/restaurants")
@Validated
@Tag(name = "Restaurants", description = "Restaurant management operations")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Operation(summary = "Create a new restaurant", description = "Creates a new restaurant for an organization")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Restaurant created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Organization not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(
            @Valid @RequestBody RestaurantCreateRequest request) throws SQLException {
        
        log.info("Received request to create restaurant: {}", request.getName());
        
        Restaurant createdRestaurant = restaurantService.createRestaurant(request);
        RestaurantResponse response = restaurantMapper.toResponse(createdRestaurant);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a restaurant", description = "Updates an existing restaurant")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Restaurant updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Restaurant not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant(
            @Parameter(description = "Restaurant ID") @PathVariable @NotBlank String id,
            @Valid @RequestBody RestaurantUpdateRequest request) throws SQLException {
        
        log.info("Received request to update restaurant: {}", id);
        
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, request);
        RestaurantResponse response = restaurantMapper.toResponse(updatedRestaurant);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get restaurant by ID", description = "Retrieves a restaurant by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Restaurant found"),
        @ApiResponse(responseCode = "404", description = "Restaurant not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(
            @Parameter(description = "Restaurant ID") @PathVariable @NotBlank String id) throws SQLException {
        
        log.debug("Retrieving restaurant with ID: {}", id);
        
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        RestaurantResponse response = restaurantMapper.toResponse(restaurant);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<?> getRestaurantsByOrganization(@PathVariable String organizationId) {
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurantsByOrganization(organizationId);
            List<RestaurantResponse> responses = restaurantMapper.toResponseList(restaurants);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get restaurants: " + e.getMessage());
        }
    }

    @GetMapping("/organization/{organizationId}/active")
    public ResponseEntity<?> getActiveRestaurantsByOrganization(@PathVariable String organizationId) {
        try {
            List<Restaurant> restaurants = restaurantService.getActiveRestaurantsByOrganization(organizationId);
            List<RestaurantResponse> responses = restaurantMapper.toResponseList(restaurants);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active restaurants: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable String id) {
        try {
            boolean deleted = restaurantService.deleteRestaurant(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to delete restaurant: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<?> toggleRestaurantStatus(@PathVariable String id) {
        try {
            boolean updated = restaurantService.toggleRestaurantStatus(id);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to toggle restaurant status: " + e.getMessage());
        }
    }

    @GetMapping("/organization/{organizationId}/count")
    public ResponseEntity<?> getRestaurantCount(@PathVariable String organizationId) {
        try {
            long count = restaurantService.getRestaurantCount(organizationId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get restaurant count: " + e.getMessage());
        }
    }

    @GetMapping("/organization/{organizationId}/active/count")
    public ResponseEntity<?> getActiveRestaurantCount(@PathVariable String organizationId) {
        try {
            long count = restaurantService.getActiveRestaurantCount(organizationId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active restaurant count: " + e.getMessage());
        }
    }
}