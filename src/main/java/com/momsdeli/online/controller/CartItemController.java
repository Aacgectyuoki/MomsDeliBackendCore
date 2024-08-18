package com.momsdeli.online.controller;

import com.momsdeli.online.dto.CartItemDTO;
import com.momsdeli.online.mapper.CartItemMapper;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartItemMapper cartItemMapper;

    @PostMapping
    public ResponseEntity<CartItemDTO> createCartItem(@RequestBody CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemMapper.cartItemDTOToCartItem(cartItemDTO);
        cartItem = cartItemService.createCartItem(cartItem);
        return ResponseEntity.ok(cartItemMapper.cartItemToCartItemDTO(cartItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemDTO> getCartItemById(@PathVariable Long id) {
        CartItem cartItem = cartItemService.getCartItemById(id);
        if (cartItem != null) {
            return ResponseEntity.ok(cartItemMapper.cartItemToCartItemDTO(cartItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItemMapper.cartItemToCartItemDTOList(cartItems));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Long id, @RequestBody CartItemDTO cartItemDTO) {
        CartItem existingCartItem = cartItemService.getCartItemById(id);
        if (existingCartItem != null) {
            cartItemMapper.updateCartItemFromDTO(cartItemDTO, existingCartItem);
            CartItem updatedCartItem = cartItemService.updateCartItem(existingCartItem);
            return ResponseEntity.ok(cartItemMapper.cartItemToCartItemDTO(updatedCartItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        boolean deleted = cartItemService.deleteCartItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
