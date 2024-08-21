package com.momsdeli.online.repository;

import com.momsdeli.online.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE category_id = :categoryId", nativeQuery = true)
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM products WHERE name LIKE %:keyword%", nativeQuery = true)
    List<Product> searchByName(@Param("keyword") String keyword);

    // Find products by name containing a specific string, case insensitive
    List<Product> findByNameContainingIgnoreCase(String name);

    // Find products by category name
    List<Product> findByCategory_Name(String categoryName);


    // Find products within a specific price range
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Find products that have stock quantity greater than a specified amount (in stock)
    List<Product> findByStockQuantityGreaterThan(int quantity);


    @Query("SELECT p FROM Product p ORDER BY p.averageRating DESC")
    List<Product> findTopRatedProducts();

}