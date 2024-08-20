package com.momsdeli.online.repository;

import com.momsdeli.online.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM reviews WHERE product_id = :productId", nativeQuery = true)
    List<Review> findByProductId(@Param("productId") Long productId);

    @Query(value = "SELECT * FROM reviews WHERE user_id = :userId", nativeQuery = true)
    List<Review> findByUserId(@Param("userId") Long userId);
}