package com.koder.course.applayered.api;

import com.koder.course.applayered.dto.ProductRequest;
import com.koder.course.applayered.dto.ProductResponse;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.UUID;

/**
 * RESTful API interface for managing Products.
 * Provides CRUD operations using ProductRequest as input and ProductResponse as output.
 */
@RequestMapping("/products")
public interface ProductApis {

    /**
     * Create a new product.
     *
     * @param request the product data to create
     * @return the created product response
     */
    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    @PostMapping
    ResponseEntity<ProductResponse> createProduct(
            @RequestBody ProductRequest request
    );

    /**
     * Get a product by its UUID.
     *
     * @param uuid the UUID of the product
     * @return the product response
     */
    @Operation(summary = "Get a product by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    @GetMapping("/{uuid}")
    ResponseEntity<ProductResponse> getProduct(
            @Parameter(description = "UUID of the product") @PathVariable UUID uuid
    );

    /**
     * Get all products.
     *
     * @return list of all product responses
     */
    @Operation(summary = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of products",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class)))
    })
    @GetMapping
    ResponseEntity<List<ProductResponse>> getAllProducts();

    /**
     * Update an existing product by its UUID.
     *
     * @param uuid the UUID of the product to update
     * @param request the updated product data
     * @return the updated product response
     */
    @Operation(summary = "Update a product by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    @PutMapping("/{uuid}")
    ResponseEntity<ProductResponse> updateProduct(
            @Parameter(description = "UUID of the product") @PathVariable UUID uuid,
            @RequestBody ProductRequest request
    );

    /**
     * Delete a product by its UUID.
     *
     * @param uuid the UUID of the product to delete
     * @return no content
     */
    @Operation(summary = "Delete a product by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    @DeleteMapping("/{uuid}")
    ResponseEntity<Void> deleteProduct(
            @Parameter(description = "UUID of the product") @PathVariable UUID uuid
    );
}