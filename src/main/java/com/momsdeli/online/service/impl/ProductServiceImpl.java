package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.dto.ProductImageDTO;
import com.momsdeli.online.exception.DuplicateSKUException;
import com.momsdeli.online.exception.ProductNotFoundException;
import com.momsdeli.online.exception.CategoryNotFoundException;
import com.momsdeli.online.mapper.ProductMapper;
import com.momsdeli.online.mapper.ProductImageMapper;
import com.momsdeli.online.model.Category;
import com.momsdeli.online.model.Product;
import com.momsdeli.online.model.ProductImage;
import com.momsdeli.online.repository.CategoryRepository;
import com.momsdeli.online.repository.ProductRepository;
import com.momsdeli.online.repository.ProductImageRepository;
import com.momsdeli.online.service.ProductService;
import com.momsdeli.online.service.S3Service;
import com.momsdeli.online.utils.SkuGeneratorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementation of ProductService interface.
 * Provides business logic for managing products, including CRUD operations,
 * image handling, and advanced search and filter functionalities.
 *
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductMapper productMapper;
    private final ProductImageMapper productImageMapper;
    private final S3Service s3Service;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO, MultipartFile image) {
        log.info("Creating a new product with an image: {}", productDTO);

        //check if the category is valid

        Integer categoryId = productDTO.getCategory();
        log.info("Category ID: {}", categoryId);  // Ensure this is a numeric value
        Category category = categoryRepository.findById(Long.valueOf(categoryId))
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + categoryId));


        // Automatically generate SKU based on the category
        long productCount = productRepository.countByCategory(category);
        String generatedSku = SkuGeneratorUtil.generateSkuBasedOnCategory(category, productCount);
        productDTO.setSku(generatedSku);

        // Check for duplicate SKU
        if (productRepository.existsBySku(generatedSku)) {
            throw new DuplicateSKUException("Product with SKU " + generatedSku + " already exists.");
        }


        log.info("Mapping ProductDTO to Product entity...");
        log.info("ProductDTO Category ID: {}", productDTO.getCategory());
        // Map DTO to Product entity
        Product product = productMapper.toEntity(productDTO);
        product.setCategory(category);

        log.info("Mapped Product entity: {}", product);


        // Handle image upload
        if (image != null && !image.isEmpty()) {
            String imageUrl = s3Service.uploadFile(image);
            product.setImageUrl(imageUrl);  // Set the image URL directly in the Product entity
        }

        // Save the product
        Product savedProduct = productRepository.save(product);
        log.info("Product created successfully with ID: {} and associated image URL", savedProduct.getId());

        // Return the saved product as DTO
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, MultipartFile image) {
        log.info("Updating product with ID: {}", id);

        // Find the existing product
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        // Map DTO to Product entity
        productMapper.updateProductFromDTO(productDTO, product);

        // Handle image upload if provided
        if (image != null && !image.isEmpty()) {
            String imageUrl = s3Service.uploadFile(image);
            product.setImageUrl(imageUrl);  // Update the product's image URL
        }

        // Save the updated product
        Product updatedProduct = productRepository.save(product);
        log.info("Product updated successfully with ID: {}", updatedProduct.getId());

        // Return the updated product as DTO
        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product with ID: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        productRepository.delete(product);
        log.info("Product deleted successfully with ID: {}", id);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        log.info("Retrieving product with ID: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("Retrieving all products");

        List<Product> products = productRepository.findAll();
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        log.info("Retrieving products by category ID: {}", categoryId);

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + categoryId));

        List<Product> products = productRepository.findByCategory(category);
        return productMapper.toDTOs(products);
    }

    @Override
    public ProductImageDTO addProductImage(Long productId, ProductImageDTO productImageDTO) {
        log.info("Adding image to product with ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));

        ProductImage productImage = productImageMapper.toEntity(productImageDTO);
        productImage.setProduct(product);

        ProductImage savedImage = productImageRepository.save(productImage);
        log.info("Image added successfully with ID: {} to product ID: {}", savedImage.getId(), productId);

        return productImageMapper.toDTO(savedImage);
    }

    @Override
    public void removeProductImage(Long productId, Long imageId) {
        log.info("Removing image with ID: {} from product with ID: {}", imageId, productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));

        ProductImage image = productImageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found with ID: " + imageId)); // Or a custom exception

        if (!image.getProduct().equals(product)) {
            throw new RuntimeException("Image does not belong to the product with ID: " + productId);
        }

        productImageRepository.delete(image);
        log.info("Image removed successfully with ID: {} from product ID: {}", imageId, productId);
    }

    @Override
    public List<ProductImageDTO> getProductImages(Long productId) {
        log.info("Retrieving images for product with ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + productId));

        List<ProductImage> images = productImageRepository.findByProduct(product);
        return productImageMapper.toDTOs(images);
    }

    @Override
    public List<ProductDTO> searchProductsByName(String name) {
        log.info("Searching products by name: {}", name);

        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        log.info("Retrieving products by price range: {} - {}", minPrice, maxPrice);

        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getProductsByStockAvailability(boolean available) {
        log.info("Retrieving products by stock availability: {}", available);

        List<Product> products;
        if (available) {
            products = productRepository.findByStockQuantityGreaterThan(0);
        } else {
            products = productRepository.findByStockQuantityEquals(0);
        }
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getTopRatedProducts() {
        log.info("Retrieving top-rated products");

        List<Product> products = productRepository.findTopRatedProducts();
        return productMapper.toDTOs(products);
    }
}
