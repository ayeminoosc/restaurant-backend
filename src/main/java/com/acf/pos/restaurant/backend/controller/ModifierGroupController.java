package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.dto.ModifierGroupCreateRequest;
import com.acf.pos.restaurant.backend.dto.ModifierGroupResponse;
import com.acf.pos.restaurant.backend.dto.ModifierGroupUpdateRequest;
import com.acf.pos.restaurant.backend.entity.ModifierGroup;
import com.acf.pos.restaurant.backend.mapper.ModifierGroupMapper;
import com.acf.pos.restaurant.backend.service.ModifierGroupService;
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
@RequestMapping("/api/modifier-groups")
@Validated
@Tag(name = "Modifier Groups", description = "Modifier group management operations")
public class ModifierGroupController {

    @Autowired
    private ModifierGroupService modifierGroupService;

    @Autowired
    private ModifierGroupMapper modifierGroupMapper;

    @Operation(summary = "Create a new modifier group", description = "Creates a new modifier group")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Modifier group created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<ModifierGroupResponse> createModifierGroup(
            @Valid @RequestBody ModifierGroupCreateRequest request) throws SQLException {
        
        log.info("Received request to create modifier group: {}", request.getName());
        
        ModifierGroup createdModifierGroup = modifierGroupService.createModifierGroup(request);
        ModifierGroupResponse response = modifierGroupMapper.toResponse(createdModifierGroup);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a modifier group", description = "Updates an existing modifier group")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Modifier group updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Modifier group not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ModifierGroupResponse> updateModifierGroup(
            @Parameter(description = "Modifier Group ID") @PathVariable @NotBlank String id,
            @Valid @RequestBody ModifierGroupUpdateRequest request) throws SQLException {
        
        log.info("Received request to update modifier group: {}", id);
        
        ModifierGroup updatedModifierGroup = modifierGroupService.updateModifierGroup(id, request);
        ModifierGroupResponse response = modifierGroupMapper.toResponse(updatedModifierGroup);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get modifier group by ID", description = "Retrieves a modifier group by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Modifier group found"),
        @ApiResponse(responseCode = "404", description = "Modifier group not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ModifierGroupResponse> getModifierGroupById(
            @Parameter(description = "Modifier Group ID") @PathVariable @NotBlank String id) throws SQLException {
        
        log.debug("Retrieving modifier group with ID: {}", id);
        
        ModifierGroup modifierGroup = modifierGroupService.getModifierGroupById(id);
        ModifierGroupResponse response = modifierGroupMapper.toResponse(modifierGroup);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllModifierGroups() {
        try {
            List<ModifierGroup> modifierGroups = modifierGroupService.getAllModifierGroups();
            List<ModifierGroupResponse> responses = modifierGroupMapper.toResponseList(modifierGroups);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get modifier groups: " + e.getMessage());
        }
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveModifierGroups() {
        try {
            List<ModifierGroup> modifierGroups = modifierGroupService.getActiveModifierGroups();
            List<ModifierGroupResponse> responses = modifierGroupMapper.toResponseList(modifierGroups);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active modifier groups: " + e.getMessage());
        }
    }

    @GetMapping("/required")
    public ResponseEntity<?> getRequiredModifierGroups() {
        try {
            List<ModifierGroup> modifierGroups = modifierGroupService.getRequiredModifierGroups();
            List<ModifierGroupResponse> responses = modifierGroupMapper.toResponseList(modifierGroups);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get required modifier groups: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModifierGroup(@PathVariable String id) {
        try {
            boolean deleted = modifierGroupService.deleteModifierGroup(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to delete modifier group: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<?> toggleModifierGroupStatus(@PathVariable String id) {
        try {
            boolean updated = modifierGroupService.toggleModifierGroupStatus(id);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to toggle modifier group status: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/display-order")
    public ResponseEntity<?> updateDisplayOrder(@PathVariable String id, @RequestBody Map<String, Integer> request) {
        try {
            Integer newOrder = request.get("displayOrder");
            if (newOrder == null) {
                return ResponseEntity.badRequest().body("Display order is required");
            }
            
            boolean updated = modifierGroupService.updateDisplayOrder(id, newOrder);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to update display order: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> getModifierGroupCount() {
        try {
            long count = modifierGroupService.getModifierGroupCount();
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get modifier group count: " + e.getMessage());
        }
    }

    @GetMapping("/active/count")
    public ResponseEntity<?> getActiveModifierGroupCount() {
        try {
            long count = modifierGroupService.getActiveModifierGroupCount();
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active modifier group count: " + e.getMessage());
        }
    }
}