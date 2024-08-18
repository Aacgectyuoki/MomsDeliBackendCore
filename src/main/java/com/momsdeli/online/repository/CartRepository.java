package com.momsdeli.online.repository;

import com.momsdeli.online.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import com.momsdeli.online.model.CartItem;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
