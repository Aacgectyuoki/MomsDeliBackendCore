package com.momsdeli.online.controller;

import com.momsdeli.online.request.CartRequest;
import com.momsdeli.online.response.CartItemResponse;
import com.momsdeli.online.response.CartResponse;
import com.momsdeli.online.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public CartResponse addItemToCart(@RequestBody CartRequest request) {
        return cartService.addItemToCart(request);
    }

    @PutMapping("/{cartId}")
    public CartResponse updateItemInCart(@PathVariable Long cartId, @RequestBody CartRequest request) {
        // Assuming CartRequest has the necessary data to update a CartItem and Cart
        return cartService.addOrUpdateItem(request);
    }

    @DeleteMapping("/{cartId}")
    public void removeItemFromCart(@PathVariable Long cartId) {
        cartService.removeItem(cartId);
    }

    @GetMapping
    public List<CartItemResponse> getCartItems() {
        return cartService.getAllCartItems();
    }
}