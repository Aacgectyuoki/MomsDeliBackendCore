package com.momsdeli.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.momsdeli.online.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
