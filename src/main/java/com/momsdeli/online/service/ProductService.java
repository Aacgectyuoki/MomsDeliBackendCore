package com.momsdeli.online.service;

import com.momsdeli.online.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 21/08/2024
 */
public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, MultipartFile imageFile);

    ProductDTO updateProduct(Long id, ProductDTO productDTO, MultipartFile image);

    void deleteProduct(Long id);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts();

    List<ProductDTO> searchProductsByName(String name);

    List<ProductDTO> getProductsByCategory(String categoryName);

    String getProductImageUrl(Long id);

    Page<ProductDTO> getProductsPaginated(int page, int size);

    List<ProductDTO> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductDTO> getProductsByStockAvailability();

    List<ProductDTO> getTopRatedProducts();
}
