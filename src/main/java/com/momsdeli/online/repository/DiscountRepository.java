package com.momsdeli.online.repository;

import com.momsdeli.online.model.Discount;
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
public interface DiscountRepository extends JpaRepository<Discount, Long> {

    @Query(value = "SELECT * FROM discounts WHERE product_id = :productId", nativeQuery = true)
    List<Discount> findByProductId(@Param("productId") Long productId);
}