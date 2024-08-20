package com.momsdeli.online.repository;

import com.momsdeli.online.model.Order;
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
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders WHERE user_id = :userId", nativeQuery = true)
    List<Order> findByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM orders WHERE status = :status", nativeQuery = true)
    List<Order> findByStatus(@Param("status") String status);
}