package com.momsdeli.online.service;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.dto.ProductImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing products.
 * Defines operations for creating, updating, deleting, and retrieving products.
 * Also includes methods for handling product images and advanced search and filtering.
 *
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param productDTO the product data transfer object
     * @return the created product DTO
     */
    ProductDTO createProduct(ProductDTO productDTO, MultipartFile image);

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update
     * @param productDTO the updated product data transfer object
     * @return the updated product DTO
     */
    ProductDTO updateProduct(Long id, ProductDTO productDTO, MultipartFile image);

    /**
     * Deletes a product by ID.
     *
     * @param id the ID of the product to delete
     */
    void deleteProduct(Long id);

    /**
     * Retrieves a product by ID.
     *
     * @param id the ID of the product to retrieve
     * @return the product DTO
     */
    ProductDTO getProductById(Long id);

    /**
     * Retrieves all products.
     *
     * @return the list of all product DTOs
     */
    List<ProductDTO> getAllProducts();

    /**
     * Retrieves products by category.
     *
     * @param categoryId the ID of the category
     * @return the list of product DTOs in the specified category
     */
    List<ProductDTO> getProductsByCategory(Long categoryId);

    /**
     * Adds an image to a product.
     *
     * @param productId the ID of the product
     * @param productImageDTO the product image data transfer object
     * @return the product image DTO
     */
    ProductImageDTO addProductImage(Long productId, ProductImageDTO productImageDTO);

    /**
     * Removes an image from a product.
     *
     * @param productId the ID of the product
     * @param imageId the ID of the image to remove
     */
    void removeProductImage(Long productId, Long imageId);

    /**
     * Retrieves all images for a product.
     *
     * @param productId the ID of the product
     * @return the list of product image DTOs
     */
    List<ProductImageDTO> getProductImages(Long productId);

    /**
     * Searches products by name.
     *
     * @param name the name of the product to search
     * @return the list of matching product DTOs
     */
    List<ProductDTO> searchProductsByName(String name);

    /**
     * Retrieves products by price range.
     *
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @return the list of product DTOs within the specified price range
     */
    List<ProductDTO> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    /**
     * Retrieves products by stock availability.
     *
     * @param available true if only in-stock products should be retrieved, false otherwise
     * @return the list of product DTOs with the specified stock availability
     */
    List<ProductDTO> getProductsByStockAvailability(boolean available);

    /**
     * Retrieves top-rated products.
     *
     * @return the list of top-rated product DTOs
     */
    List<ProductDTO> getTopRatedProducts();
}
