package com.momsdeli.online.repository;

import com.momsdeli.online.model.Product;
import com.momsdeli.online.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the entity {@link ProductImage}.
 * Provides methods for interacting with the database.
 *
 * @author Shahbaz Khan
 * @date 29/08/2024
 */
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    /**
     * Finds all images associated with a given product.
     *
     * @param product the product entity
     * @return list of associated product images
     */
    List<ProductImage> findByProduct(Product product);
}
