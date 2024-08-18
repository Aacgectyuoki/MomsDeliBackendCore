package com.momsdeli.online.controller;

import com.momsdeli.online.request.CartItemRequest;
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
    public CartItemResponse addItemToCart(@RequestBody CartItemRequest request) {
//        request.setId(cartId);
        return cartService.addOrUpdateItem(request);
    }

    @PutMapping("/{cartId}")
    public CartItemResponse updateItemInCart(@PathVariable Long cartId, @RequestBody CartItemRequest request) {
        request.getCartItemRequest(cartId); // Assuming CartRequest has a method to set ID
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

    @DeleteMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }
}
