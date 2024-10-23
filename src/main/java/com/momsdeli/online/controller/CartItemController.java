package com.momsdeli.online.controller;

import com.momsdeli.online.dto.CartItemDTO;
import com.momsdeli.online.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    // 1. Add a new item to the cart
    @PostMapping
    public ResponseEntity<CartItemDTO> addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        CartItemDTO addedCartItem = cartItemService.addCartItem(cartItemDTO);
        return new ResponseEntity<>(addedCartItem, HttpStatus.CREATED);
    }

    // 2. Get all items in the cart for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItemDTO>> getCartItemsByUser(@PathVariable Long userId) {
        List<CartItemDTO> cartItems = cartItemService.getCartItemsByUser(userId);
        return ResponseEntity.ok(cartItems);
    }

    // 3. Update the quantity of an item in the cart
    @PutMapping("/{id}")
    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Long id, @RequestBody CartItemDTO cartItemDTO) {
        CartItemDTO updatedCartItem = cartItemService.updateCartItem(id, cartItemDTO);
        return ResponseEntity.ok(updatedCartItem);
    }

    // 4. Remove an item from the cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
        cartItemService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }

    // 5. Clear all items in the user's cart
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        cartItemService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }
}
