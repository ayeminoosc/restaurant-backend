package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.dto.MenuItemCreateRequest;
import com.acf.pos.restaurant.backend.dto.MenuItemResponse;
import com.acf.pos.restaurant.backend.dto.MenuItemUpdateRequest;
import com.acf.pos.restaurant.backend.entity.MenuItem;
import com.acf.pos.restaurant.backend.mapper.MenuItemMapper;
import com.acf.pos.restaurant.backend.service.MenuItemService;
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
@RequestMapping("/api/menu-items")
@Validated
@Tag(name = "Menu Items", description = "Menu item management operations")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MenuItemMapper menuItemMapper;

    @Operation(summary = "Create a new menu item", description = "Creates a new menu item for a category")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Menu item created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Category not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<MenuItemResponse> createMenuItem(
            @Valid @RequestBody MenuItemCreateRequest request) throws SQLException {
        
        log.info("Received request to create menu item: {}", request.getName());
        
        MenuItem createdMenuItem = menuItemService.createMenuItem(request);
        MenuItemResponse response = menuItemMapper.toResponse(createdMenuItem);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a menu item", description = "Updates an existing menu item")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Menu item updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Menu item not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponse> updateMenuItem(
            @Parameter(description = "Menu Item ID") @PathVariable @NotBlank String id,
            @Valid @RequestBody MenuItemUpdateRequest request) throws SQLException {
        
        log.info("Received request to update menu item: {}", id);
        
        MenuItem updatedMenuItem = menuItemService.updateMenuItem(id, request);
        MenuItemResponse response = menuItemMapper.toResponse(updatedMenuItem);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get menu item by ID", description = "Retrieves a menu item by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Menu item found"),
        @ApiResponse(responseCode = "404", description = "Menu item not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponse> getMenuItemById(
            @Parameter(description = "Menu Item ID") @PathVariable @NotBlank String id) throws SQLException {
        
        log.debug("Retrieving menu item with ID: {}", id);
        
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        MenuItemResponse response = menuItemMapper.toResponse(menuItem);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getMenuItemsByCategory(@PathVariable String categoryId) {
        try {
            List<MenuItem> menuItems = menuItemService.getAllMenuItemsByCategory(categoryId);
            List<MenuItemResponse> responses = menuItemMapper.toResponseList(menuItems);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get menu items: " + e.getMessage());
        }
    }

    @GetMapping("/category/{categoryId}/active")
    public ResponseEntity<?> getActiveMenuItemsByCategory(@PathVariable String categoryId) {
        try {
            List<MenuItem> menuItems = menuItemService.getActiveMenuItemsByCategory(categoryId);
            List<MenuItemResponse> responses = menuItemMapper.toResponseList(menuItems);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active menu items: " + e.getMessage());
        }
    }

    @GetMapping("/category/{categoryId}/available")
    public ResponseEntity<?> getAvailableMenuItemsByCategory(@PathVariable String categoryId) {
        try {
            List<MenuItem> menuItems = menuItemService.getAvailableMenuItemsByCategory(categoryId);
            List<MenuItemResponse> responses = menuItemMapper.toResponseList(menuItems);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get available menu items: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable String id) {
        try {
            boolean deleted = menuItemService.deleteMenuItem(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to delete menu item: " + e.getMessage());
        }
    }

    // MenuItem doesn't have an active field, only availability toggle is available

    @PatchMapping("/{id}/toggle-availability")
    public ResponseEntity<?> toggleMenuItemAvailability(@PathVariable String id) {
        try {
            boolean updated = menuItemService.toggleMenuItemAvailability(id);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to toggle menu item availability: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/display-order")
    public ResponseEntity<?> updateDisplayOrder(@PathVariable String id, @RequestBody Map<String, Integer> request) {
        try {
            Integer newOrder = request.get("displayOrder");
            if (newOrder == null) {
                return ResponseEntity.badRequest().body("Display order is required");
            }
            
            boolean updated = menuItemService.updateDisplayOrder(id, newOrder);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to update display order: " + e.getMessage());
        }
    }

    @GetMapping("/category/{categoryId}/count")
    public ResponseEntity<?> getMenuItemCount(@PathVariable String categoryId) {
        try {
            long count = menuItemService.getMenuItemCount(categoryId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get menu item count: " + e.getMessage());
        }
    }

    @GetMapping("/category/{categoryId}/active/count")
    public ResponseEntity<?> getActiveMenuItemCount(@PathVariable String categoryId) {
        try {
            long count = menuItemService.getActiveMenuItemCount(categoryId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active menu item count: " + e.getMessage());
        }
    }
}