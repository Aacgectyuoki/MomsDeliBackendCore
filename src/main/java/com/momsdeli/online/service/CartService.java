package com.momsdeli.online.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.repository.CartRepository;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public CartItem addItemToCart(CartItem item) {
        return cartRepository.save(item);
    }

    @Transactional
    public void removeItemFromCart(Long itemId) {
        cartRepository.deleteById(itemId);
    }

    @Transactional
    public CartItem updateItemQuantity(Long itemId, Integer quantity) {
        CartItem item = cartRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        return cartRepository.save(item);
    }

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    @Transactional
    public void clearCart() {
        cartRepository.deleteAll();
    }
}
