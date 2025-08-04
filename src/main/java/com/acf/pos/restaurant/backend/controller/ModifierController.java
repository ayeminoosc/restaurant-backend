package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.dto.ModifierCreateRequest;
import com.acf.pos.restaurant.backend.dto.ModifierResponse;
import com.acf.pos.restaurant.backend.dto.ModifierUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Modifier;
import com.acf.pos.restaurant.backend.mapper.ModifierMapper;
import com.acf.pos.restaurant.backend.service.ModifierService;
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
@RequestMapping("/api/modifiers")
@Validated
@Tag(name = "Modifiers", description = "Modifier management operations")
public class ModifierController {

    @Autowired
    private ModifierService modifierService;

    @Autowired
    private ModifierMapper modifierMapper;

    @Operation(summary = "Create a new modifier", description = "Creates a new modifier for a modifier group")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Modifier created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Modifier group not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<ModifierResponse> createModifier(
            @Valid @RequestBody ModifierCreateRequest request) throws SQLException {
        
        log.info("Received request to create modifier: {}", request.getName());
        
        Modifier createdModifier = modifierService.createModifier(request);
        ModifierResponse response = modifierMapper.toResponse(createdModifier);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a modifier", description = "Updates an existing modifier")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Modifier updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Modifier not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ModifierResponse> updateModifier(
            @Parameter(description = "Modifier ID") @PathVariable @NotBlank String id,
            @Valid @RequestBody ModifierUpdateRequest request) throws SQLException {
        
        log.info("Received request to update modifier: {}", id);
        
        Modifier updatedModifier = modifierService.updateModifier(id, request);
        ModifierResponse response = modifierMapper.toResponse(updatedModifier);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get modifier by ID", description = "Retrieves a modifier by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Modifier found"),
        @ApiResponse(responseCode = "404", description = "Modifier not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ModifierResponse> getModifierById(
            @Parameter(description = "Modifier ID") @PathVariable @NotBlank String id) throws SQLException {
        
        log.debug("Retrieving modifier with ID: {}", id);
        
        Modifier modifier = modifierService.getModifierById(id);
        ModifierResponse response = modifierMapper.toResponse(modifier);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/modifier-group/{modifierGroupId}")
    public ResponseEntity<?> getModifiersByGroup(@PathVariable String modifierGroupId) {
        try {
            List<Modifier> modifiers = modifierService.getAllModifiersByGroup(modifierGroupId);
            List<ModifierResponse> responses = modifierMapper.toResponseList(modifiers);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get modifiers: " + e.getMessage());
        }
    }

    @GetMapping("/modifier-group/{modifierGroupId}/active")
    public ResponseEntity<?> getActiveModifiersByGroup(@PathVariable String modifierGroupId) {
        try {
            List<Modifier> modifiers = modifierService.getActiveModifiersByGroup(modifierGroupId);
            List<ModifierResponse> responses = modifierMapper.toResponseList(modifiers);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active modifiers: " + e.getMessage());
        }
    }

    @GetMapping("/modifier-group/{modifierGroupId}/default")
    public ResponseEntity<?> getDefaultModifiersByGroup(@PathVariable String modifierGroupId) {
        try {
            List<Modifier> modifiers = modifierService.getDefaultModifiersByGroup(modifierGroupId);
            List<ModifierResponse> responses = modifierMapper.toResponseList(modifiers);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get default modifiers: " + e.getMessage());
        }
    }

    @GetMapping("/modifier-group/{modifierGroupId}/free")
    public ResponseEntity<?> getFreeModifiersByGroup(@PathVariable String modifierGroupId) {
        try {
            List<Modifier> modifiers = modifierService.getFreeModifiersByGroup(modifierGroupId);
            List<ModifierResponse> responses = modifierMapper.toResponseList(modifiers);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get free modifiers: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModifier(@PathVariable String id) {
        try {
            boolean deleted = modifierService.deleteModifier(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to delete modifier: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<?> toggleModifierStatus(@PathVariable String id) {
        try {
            boolean updated = modifierService.toggleModifierStatus(id);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to toggle modifier status: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/toggle-default")
    public ResponseEntity<?> toggleDefaultStatus(@PathVariable String id) {
        try {
            boolean updated = modifierService.toggleDefaultStatus(id);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to toggle default status: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/display-order")
    public ResponseEntity<?> updateDisplayOrder(@PathVariable String id, @RequestBody Map<String, Integer> request) {
        try {
            Integer newOrder = request.get("displayOrder");
            if (newOrder == null) {
                return ResponseEntity.badRequest().body("Display order is required");
            }
            
            boolean updated = modifierService.updateDisplayOrder(id, newOrder);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to update display order: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<?> updatePrice(@PathVariable String id, @RequestBody Map<String, Double> request) {
        try {
            Double newPrice = request.get("price");
            if (newPrice == null) {
                return ResponseEntity.badRequest().body("Price is required");
            }
            
            boolean updated = modifierService.updatePrice(id, newPrice);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to update price: " + e.getMessage());
        }
    }

    @GetMapping("/modifier-group/{modifierGroupId}/count")
    public ResponseEntity<?> getModifierCount(@PathVariable String modifierGroupId) {
        try {
            long count = modifierService.getModifierCount(modifierGroupId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get modifier count: " + e.getMessage());
        }
    }

    @GetMapping("/modifier-group/{modifierGroupId}/active/count")
    public ResponseEntity<?> getActiveModifierCount(@PathVariable String modifierGroupId) {
        try {
            long count = modifierService.getActiveModifierCount(modifierGroupId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active modifier count: " + e.getMessage());
        }
    }
}