package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.ProductDTO;
import com.momsdeli.online.mapper.ProductMapper;
import com.momsdeli.online.model.Product;
import com.momsdeli.online.repository.ProductRepository;
import com.momsdeli.online.service.ProductService;
import com.momsdeli.online.utils.AwsS3Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AwsS3Util awsS3Util;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, MultipartFile imageFile) {
        log.info("Creating a new product with name: {}", productDTO.getName());

        // Upload image to S3 and get URL
        String imageUrl = awsS3Util.uploadFile(imageFile);
        productDTO.setImageUrl(imageUrl);

        // Convert DTO to entity
        Product product = productMapper.toEntity(productDTO);

        // Save product in the database
        product = productRepository.save(product);

        log.info("Product created successfully with ID: {}", product.getId());

        // Convert saved entity back to DTO and return
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, MultipartFile image) {
        log.info("Updating product with ID: {}", id);
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productMapper.updateProductFromDTO(productDTO, existingProduct);

        if (image != null && !image.isEmpty()) {
            String imageUrl = awsS3Util.uploadFile(image);
            existingProduct.setImageUrl(imageUrl);
        }

        Product updatedProduct = productRepository.save(existingProduct);
        log.info("Product updated successfully with ID: {}", updatedProduct.getId());

        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product with ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
        log.info("Product deleted successfully with ID: {}", id);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        log.info("Fetching product with ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> searchProductsByName(String name) {
        log.info("Searching products with name: {}", name);
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryName) {
        log.info("Fetching products by category: {}", categoryName);
        List<Product> products = productRepository.findByCategory_Name(categoryName);
        return productMapper.toDTOs(products);
    }

    @Override
    public String getProductImageUrl(Long id) {
        log.info("Fetching image URL for product with ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product.getImageUrl();
    }

    @Override
    public Page<ProductDTO> getProductsPaginated(int page, int size) {
        log.info("Fetching products with pagination - page: {}, size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(productMapper::toDTO);
    }


    @Override
    public List<ProductDTO> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        log.info("Fetching products with price between {} and {}", minPrice, maxPrice);
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getProductsByStockAvailability() {
        log.info("Fetching products that are in stock");
        List<Product> products = productRepository.findByStockQuantityGreaterThan(0);
        return productMapper.toDTOs(products);
    }

    @Override
    public List<ProductDTO> getTopRatedProducts() {
        log.info("Fetching top-rated products");
        List<Product> products = productRepository.findTopRatedProducts();
        return productMapper.toDTOs(products);
    }


}
