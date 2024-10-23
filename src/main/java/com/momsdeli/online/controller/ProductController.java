package com.momsdeli.online.controller;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.dto.ProductImageDTO;
import com.momsdeli.online.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * REST controller for managing products.
 * Provides endpoints for CRUD operations, image management,
 * category-based filtering, and advanced search and filtering.
 *
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {

    private final ProductService productService;


    @Operation(summary = "Create a new product with an image")
    @PostMapping
    public ResponseEntity<ProductDTO> createProductWithImage(
            @ModelAttribute ProductDTO productDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        log.info("REST request to create a new product with an image");
        ProductDTO createdProduct = productService.createProduct(productDTO, image);
        return ResponseEntity.ok(createdProduct);
    }

    @Operation(summary = "Update an existing product with an optional image")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductWithImage(
            @PathVariable Long id,
            @RequestPart("product") ProductDTO productDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        log.info("REST request to update product with ID: {} and an optional image", id);
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO, image);
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Delete a product", description = "Deletes a product by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("REST request to delete product with ID: {}", id);
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get a product by ID", description = "Retrieves a product by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        log.info("REST request to get product with ID: {}", id);
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    @Operation(summary = "Get all products", description = "Retrieves all products.")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        log.info("REST request to get all products");
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Category-Based Operations

    @Operation(summary = "Get products by category ID", description = "Retrieves products by the given category ID.")
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long categoryId) {
        log.info("REST request to get products by category ID: {}", categoryId);
        List<ProductDTO> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    // Product Image Management

    @Operation(summary = "Add an image to a product", description = "Adds an image to the specified product.")
    @PostMapping("/{productId}/images")
    public ResponseEntity<ProductImageDTO> addProductImage(@PathVariable Long productId, @RequestBody ProductImageDTO productImageDTO) {
        log.info("REST request to add image to product with ID: {}", productId);
        ProductImageDTO createdImage = productService.addProductImage(productId, productImageDTO);
        return ResponseEntity.ok(createdImage);
    }

    @Operation(summary = "Remove an image from a product", description = "Removes the specified image from the given product.")
    @DeleteMapping("/{productId}/images/{imageId}")
    public ResponseEntity<Void> removeProductImage(@PathVariable Long productId, @PathVariable Long imageId) {
        log.info("REST request to remove image with ID: {} from product with ID: {}", imageId, productId);
        productService.removeProductImage(productId, imageId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all images for a product", description = "Retrieves all images associated with the specified product.")
    @GetMapping("/{productId}/images")
    public ResponseEntity<List<ProductImageDTO>> getProductImages(@PathVariable Long productId) {
        log.info("REST request to get images for product with ID: {}", productId);
        List<ProductImageDTO> images = productService.getProductImages(productId);
        return ResponseEntity.ok(images);
    }

    // Advanced Search and Filter Operations

    @Operation(summary = "Search products by name", description = "Searches products by the given name.")
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProductsByName(@RequestParam String name) {
        log.info("REST request to search products by name: {}", name);
        List<ProductDTO> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get products by price range", description = "Retrieves products within the specified price range.")
    @GetMapping("/filter/price")
    public ResponseEntity<List<ProductDTO>> getProductsByPriceRange(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        log.info("REST request to get products by price range: {} - {}", minPrice, maxPrice);
        List<ProductDTO> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get products by stock availability", description = "Retrieves products based on their stock availability.")
    @GetMapping("/filter/stock")
    public ResponseEntity<List<ProductDTO>> getProductsByStockAvailability(@RequestParam boolean available) {
        log.info("REST request to get products by stock availability: {}", available);
        List<ProductDTO> products = productService.getProductsByStockAvailability(available);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get top-rated products", description = "Retrieves the top-rated products.")
    @GetMapping("/top-rated")
    public ResponseEntity<List<ProductDTO>> getTopRatedProducts() {
        log.info("REST request to get top-rated products");
        List<ProductDTO> products = productService.getTopRatedProducts();
        return ResponseEntity.ok(products);
    }
}
