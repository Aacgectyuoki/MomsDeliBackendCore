package com.momsdeli.online.service;

import com.momsdeli.online.repository.CartItemRepository;
import com.momsdeli.online.request.CartItemRequest;
import com.momsdeli.online.response.CartItemResponse;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.momsdeli.online.repository.CartRepository;
import com.momsdeli.online.model.Cart;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.mapper.CartMapper;
import com.momsdeli.online.request.CartRequest;
import com.momsdeli.online.response.CartResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private Cart cart;

    @Autowired
    private CartRepository cartRepository; // For Cart

//    @Autowired
//    CartItemRequest itemRequest = cartRequest.getCartItems().get(index); // Get a specific item by index

    @Autowired
    private CartItemRepository cartItemRepository; // For CartItem, previously incorrectly named

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartMapper = cartMapper;
    }

    public CartItemResponse addOrUpdateItem(CartItemRequest request) {
        CartItem cartItem = cartMapper.requestToCartItem(request);
        cartItem = cartItemRepository.save(cartItem);  // Use CartItemRepository here
        return cartMapper.cartItemToResponse(cartItem);
    }

    public void removeItem(Long id) {
        cartItemRepository.deleteById(id);  // Assuming this should also use CartItemRepository
    }

    public List<CartItemResponse> getAllCartItems() {
        return cartItemRepository.findAll().stream()  // Use CartItemRepository
                .map(cartMapper::cartItemToResponse)
                .collect(Collectors.toList());
    }

    public void clearCart() {
        cartItemRepository.deleteAll();  // Assuming this clears all CartItems
    }

//    public CartResponse addItemToCart(Long id, CartRequest request) {
//        CartItem cartItem = cartMapper.requestToCartItem(request.getCartItemRequest(id));  // Assumes CartRequest includes CartItemRequest
//        cartItem = cartItemRepository.save(cartItem);  // Save or update the CartItem
//
//        Cart cart = cartRepository.findById(cartItem.getCart().getId()).orElse(new Cart());  // Find existing cart or create new one
//        cart.addItem(cartItem);  // Method to add item to Cart, assuming Cart has a list of CartItems
//        cart = cartRepository.save(cart);  // Save the updated Cart
//
//        return cartMapper.cartToResponse(cart);  // Assuming there is a method to convert Cart to CartResponse
//    }


}
