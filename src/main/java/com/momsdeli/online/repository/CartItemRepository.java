package com.momsdeli.online.repository;

import com.momsdeli.online.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartId(Long cartId);

    List<CartItem> findByCartUserId(Long userId);
    void deleteByCartUserId(Long userId);
}
