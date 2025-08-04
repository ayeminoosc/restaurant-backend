package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.dto.PrefixCreateRequest;
import com.acf.pos.restaurant.backend.dto.PrefixResponse;
import com.acf.pos.restaurant.backend.dto.PrefixUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Prefix;
import com.acf.pos.restaurant.backend.mapper.PrefixMapper;
import com.acf.pos.restaurant.backend.service.PrefixService;
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
@RequestMapping("/api/prefixes")
@Validated
@Tag(name = "Prefixes", description = "Prefix management operations")
public class PrefixController {

    @Autowired
    private PrefixService prefixService;

    @Autowired
    private PrefixMapper prefixMapper;

    @Operation(summary = "Create a new prefix", description = "Creates a new prefix for modifiers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Prefix created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<PrefixResponse> createPrefix(
            @Valid @RequestBody PrefixCreateRequest request) throws SQLException {
        
        log.info("Received request to create prefix: {}", request.getName());
        
        Prefix createdPrefix = prefixService.createPrefix(request);
        PrefixResponse response = prefixMapper.toResponse(createdPrefix);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a prefix", description = "Updates an existing prefix")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prefix updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Prefix not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PrefixResponse> updatePrefix(
            @Parameter(description = "Prefix ID") @PathVariable @NotBlank String id,
            @Valid @RequestBody PrefixUpdateRequest request) throws SQLException {
        
        log.info("Received request to update prefix: {}", id);
        
        Prefix updatedPrefix = prefixService.updatePrefix(id, request);
        PrefixResponse response = prefixMapper.toResponse(updatedPrefix);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get prefix by ID", description = "Retrieves a prefix by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prefix found"),
        @ApiResponse(responseCode = "404", description = "Prefix not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PrefixResponse> getPrefixById(
            @Parameter(description = "Prefix ID") @PathVariable @NotBlank String id) throws SQLException {
        
        log.debug("Retrieving prefix with ID: {}", id);
        
        Prefix prefix = prefixService.getPrefixById(id);
        PrefixResponse response = prefixMapper.toResponse(prefix);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllPrefixes() {
        try {
            List<Prefix> prefixes = prefixService.getAllPrefixes();
            List<PrefixResponse> responses = prefixMapper.toResponseList(prefixes);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get prefixes: " + e.getMessage());
        }
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActivePrefixes() {
        try {
            List<Prefix> prefixes = prefixService.getActivePrefixes();
            List<PrefixResponse> responses = prefixMapper.toResponseList(prefixes);
            return ResponseEntity.ok(responses);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active prefixes: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrefix(@PathVariable String id) {
        try {
            boolean deleted = prefixService.deletePrefix(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to delete prefix: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/display-order")
    public ResponseEntity<?> updateDisplayOrder(@PathVariable String id, @RequestBody Map<String, Integer> request) {
        try {
            Integer newOrder = request.get("displayOrder");
            if (newOrder == null) {
                return ResponseEntity.badRequest().body("Display order is required");
            }
            
            boolean updated = prefixService.updateDisplayOrder(id, newOrder);
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
    public ResponseEntity<?> getPrefixCount() {
        try {
            long count = prefixService.getPrefixCount();
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get prefix count: " + e.getMessage());
        }
    }

    @GetMapping("/active/count")
    public ResponseEntity<?> getActivePrefixCount() {
        try {
            long count = prefixService.getActivePrefixCount();
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active prefix count: " + e.getMessage());
        }
    }
}