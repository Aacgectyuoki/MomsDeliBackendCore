package com.momsdeli.online.controller;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Product Management", description = "APIs for managing products")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Operation(summary = "Create a new product")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(
            @Parameter(description = "Product details") @ModelAttribute ProductDTO productDTO,
            @Parameter(description = "Product image file") @RequestPart("image") MultipartFile imageFile) {
        logger.info("API call to create a new product");
        ProductDTO createdProduct = productService.createProduct(productDTO, imageFile);
        return ResponseEntity.ok(createdProduct);
    }

    @Operation(summary = "Update an existing product")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @Parameter(description = "Product ID") @PathVariable Long id,
            @Parameter(description = "Updated product details") @ModelAttribute ProductDTO productDTO,
            @Parameter(description = "Updated product image file", required = false) @RequestPart(value = "image", required = false) MultipartFile imageFile) {
        logger.info("API call to update product with ID: {}", id);
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO, imageFile);
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Delete a product by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        logger.info("API call to delete product with ID: {}", id);
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get a product by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        logger.info("API call to fetch product with ID: {}", id);
        ProductDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        logger.info("API call to fetch all products");
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Search products by name")
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProductsByName(
            @Parameter(description = "Product name") @RequestParam String name) {
        logger.info("API call to search products by name: {}", name);
        List<ProductDTO> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get products by category")
    @GetMapping("/category")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(
            @Parameter(description = "Category name") @RequestParam String categoryName) {
        logger.info("API call to fetch products by category: {}", categoryName);
        List<ProductDTO> products = productService.getProductsByCategory(categoryName);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get product image URL")
    @GetMapping("/{id}/image")
    public ResponseEntity<String> getProductImageUrl(
            @Parameter(description = "Product ID") @PathVariable Long id) {
        logger.info("API call to fetch product image URL for product with ID: {}", id);
        String imageUrl = productService.getProductImageUrl(id);
        return ResponseEntity.ok(imageUrl);
    }

    @Operation(summary = "Get products with pagination")
    @GetMapping("/paginate")
    public ResponseEntity<Page<ProductDTO>> getProductsPaginated(
            @Parameter(description = "Page number") @RequestParam int page,
            @Parameter(description = "Page size") @RequestParam int size) {
        logger.info("API call to fetch paginated products - page: {}, size: {}", page, size);
        Page<ProductDTO> productPage = productService.getProductsPaginated(page, size);
        return ResponseEntity.ok(productPage);
    }

    @Operation(summary = "Get products by price range")
    @GetMapping("/price-range")
    public ResponseEntity<List<ProductDTO>> getProductsByPriceRange(
            @Parameter(description = "Minimum price") @RequestParam BigDecimal minPrice,
            @Parameter(description = "Maximum price") @RequestParam BigDecimal maxPrice) {
        logger.info("API call to fetch products within price range {} - {}", minPrice, maxPrice);
        List<ProductDTO> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get in-stock products")
    @GetMapping("/stock")
    public ResponseEntity<List<ProductDTO>> getProductsByStockAvailability() {
        logger.info("API call to fetch in-stock products");
        List<ProductDTO> products = productService.getProductsByStockAvailability();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Get top-rated products")
    @GetMapping("/top-rated")
    public ResponseEntity<List<ProductDTO>> getTopRatedProducts() {
        logger.info("API call to fetch top-rated products");
        List<ProductDTO> products = productService.getTopRatedProducts();
        return ResponseEntity.ok(products);
    }
}
