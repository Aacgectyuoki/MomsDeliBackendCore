package com.momsdeli.online.repository;

import com.momsdeli.online.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserId(Long userId);
}