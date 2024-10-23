package com.momsdeli.online.service;

import com.momsdeli.online.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {

    CartItemDTO addCartItem(CartItemDTO cartItemDTO);

    List<CartItemDTO> getCartItemsByUser(Long userId);

    CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO);

    void removeCartItem(Long id);

    void clearCart(Long userId);
}
