package com.momsdeli.online.controller;

import com.momsdeli.online.request.CartRequest;
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
        request.setId(cartId); // Assuming CartRequest has a method to set ID
        return cartService.addOrUpdateItem(request);
    }

    @DeleteMapping("/{cartId}")
    public void removeItemFromCart(@PathVariable Long cartId) {
        cartService.removeItem(cartId);
    }

    @GetMapping
    public List<CartResponse> getCartItems() {
        return cartService.getAllCartItems();
    }

    @DeleteMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }
}
