package com.momsdeli.online.service;

import com.momsdeli.online.mapper.CartMapper;
import com.momsdeli.online.model.Cart;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.repository.CartItemRepository;
import com.momsdeli.online.repository.CartRepository;
import com.momsdeli.online.request.CartRequest;
import com.momsdeli.online.response.CartItemResponse;
import com.momsdeli.online.response.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository; // For Cart

    @Autowired
    private CartItemRepository cartItemRepository; // For CartItem

    @Autowired
    private CartMapper cartMapper;

//    public CartResponse addOrUpdateItem(CartRequest request) {
//        // Assuming request contains the necessary details to map to a CartItem and Cart
//        CartItem cartItem = cartMapper.requestToCartItem(request);
//        cartItem = cartItemRepository.save(cartItem);
//
//        // Assuming CartItem contains reference to Cart and it needs to be updated
//        Cart cart = cartItem.getCart();
//        cart = cartRepository.save(cart);
//
//        return cartMapper.cartToResponse(cart);
//    }
    public CartResponse addOrUpdateItem(CartRequest request) {
        CartItem cartItem = cartMapper.requestToCartItem(request);
        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cartItem.setCart(cart);
        cartItem = cartItemRepository.save(cartItem);
        cart.getCartItems().add(cartItem);
        cartItem.setCart(cart); // Save the updated cart
        return cartMapper.cartToResponse(cart); // Return the updated cart
    }

    public void removeItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public List<CartItemResponse> getAllCartItems() {
        return cartItemRepository.findAll().stream()
                .map(cartMapper::cartItemToResponse)
                .collect(Collectors.toList());
    }

    public CartResponse addItemToCart(CartRequest request) {
        Cart cart = cartMapper.requestToCart(request);
        cartRepository.save(cart);
        return cartMapper.cartToResponse(cart);
    }
}