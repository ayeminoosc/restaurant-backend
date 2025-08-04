package com.acf.pos.restaurant.backend.controller;

import com.acf.pos.restaurant.backend.dto.CategoryCreateRequest;
import com.acf.pos.restaurant.backend.dto.CategoryResponse;
import com.acf.pos.restaurant.backend.dto.CategoryUpdateRequest;
import com.acf.pos.restaurant.backend.entity.Category;
import com.acf.pos.restaurant.backend.mapper.CategoryMapper;
import com.acf.pos.restaurant.backend.service.CategoryService;
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
@RequestMapping("/api/categories")
@Validated
@Tag(name = "Categories", description = "Category management operations")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Operation(summary = "Create a new category", description = "Creates a new category for a restaurant")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Category created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Restaurant or parent category not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(
            @Valid @RequestBody CategoryCreateRequest request) throws SQLException {
        
        log.info("Received request to create category: {}", request.getName());
        
        Category createdCategory = categoryService.createCategory(request);
        CategoryResponse response = categoryMapper.toResponse(createdCategory);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update a category", description = "Updates an existing category")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Category updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Category not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @Parameter(description = "Category ID") @PathVariable @NotBlank String id,
            @Valid @RequestBody CategoryUpdateRequest request) throws SQLException {
        
        log.info("Received request to update category: {}", id);
        
        Category updatedCategory = categoryService.updateCategory(id, request);
        CategoryResponse response = categoryMapper.toResponse(updatedCategory);
        
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get category by ID", description = "Retrieves a category by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Category found"),
        @ApiResponse(responseCode = "404", description = "Category not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(
            @Parameter(description = "Category ID") @PathVariable @NotBlank String id) throws SQLException {
        
        log.debug("Retrieving category with ID: {}", id);
        
        Category category = categoryService.getCategoryById(id);
        CategoryResponse response = categoryMapper.toResponse(category);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<?> getCategoriesByRestaurant(@PathVariable String restaurantId) {
        try {
            List<Category> categories = categoryService.getAllCategoriesByRestaurant(restaurantId);
            return ResponseEntity.ok(categories);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get categories: " + e.getMessage());
        }
    }

    @GetMapping("/restaurant/{restaurantId}/active")
    public ResponseEntity<?> getActiveCategoriesByRestaurant(@PathVariable String restaurantId) {
        try {
            List<Category> categories = categoryService.getActiveCategoriesByRestaurant(restaurantId);
            return ResponseEntity.ok(categories);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active categories: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
        try {
            boolean deleted = categoryService.deleteCategory(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to delete category: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<?> toggleCategoryStatus(@PathVariable String id) {
        try {
            boolean updated = categoryService.toggleCategoryStatus(id);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to toggle category status: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}/display-order")
    public ResponseEntity<?> updateDisplayOrder(@PathVariable String id, @RequestBody Map<String, Integer> request) {
        try {
            Integer newOrder = request.get("displayOrder");
            if (newOrder == null) {
                return ResponseEntity.badRequest().body("Display order is required");
            }
            
            boolean updated = categoryService.updateDisplayOrder(id, newOrder);
            if (updated) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to update display order: " + e.getMessage());
        }
    }

    @GetMapping("/restaurant/{restaurantId}/top-level")
    public ResponseEntity<?> getTopLevelCategories(@PathVariable String restaurantId) {
        try {
            List<Category> categories = categoryService.getTopLevelCategories(restaurantId);
            return ResponseEntity.ok(categories);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get top-level categories: " + e.getMessage());
        }
    }

    @GetMapping("/restaurant/{restaurantId}/top-level/active")
    public ResponseEntity<?> getActiveTopLevelCategories(@PathVariable String restaurantId) {
        try {
            List<Category> categories = categoryService.getActiveTopLevelCategories(restaurantId);
            return ResponseEntity.ok(categories);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active top-level categories: " + e.getMessage());
        }
    }

    @GetMapping("/{parentId}/subcategories")
    public ResponseEntity<?> getSubCategories(@PathVariable String parentId) {
        try {
            List<Category> categories = categoryService.getSubCategories(parentId);
            return ResponseEntity.ok(categories);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get subcategories: " + e.getMessage());
        }
    }

    @GetMapping("/{parentId}/subcategories/active")
    public ResponseEntity<?> getActiveSubCategories(@PathVariable String parentId) {
        try {
            List<Category> categories = categoryService.getActiveSubCategories(parentId);
            return ResponseEntity.ok(categories);
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get active subcategories: " + e.getMessage());
        }
    }

    @GetMapping("/restaurant/{restaurantId}/count")
    public ResponseEntity<?> getCategoryCount(@PathVariable String restaurantId) {
        try {
            long count = categoryService.getCategoryCount(restaurantId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get category count: " + e.getMessage());
        }
    }

    @GetMapping("/restaurant/{restaurantId}/top-level/count")
    public ResponseEntity<?> getTopLevelCategoryCount(@PathVariable String restaurantId) {
        try {
            long count = categoryService.getTopLevelCategoryCount(restaurantId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get top-level category count: " + e.getMessage());
        }
    }

    @GetMapping("/{parentId}/subcategories/count")
    public ResponseEntity<?> getSubCategoryCount(@PathVariable String parentId) {
        try {
            long count = categoryService.getSubCategoryCount(parentId);
            return ResponseEntity.ok(Map.of("count", count));
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Failed to get subcategory count: " + e.getMessage());
        }
    }
}