package com.momsdeli.online.repository;

import com.momsdeli.online.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

    List<WishlistItem> findByWishlistId(Long wishlistId);
}