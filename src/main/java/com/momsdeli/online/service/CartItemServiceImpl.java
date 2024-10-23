package com.momsdeli.online.service;

import com.momsdeli.online.dto.CartItemDTO;
import com.momsdeli.online.mapper.CartItemMapper;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.model.ShoppingCart;
import com.momsdeli.online.model.Product;
import com.momsdeli.online.repository.CartItemRepository;
import com.momsdeli.online.repository.ShoppingCartRepository;
import com.momsdeli.online.repository.ProductRepository;
import com.momsdeli.online.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public CartItemDTO addCartItem(CartItemDTO cartItemDTO) {
        ShoppingCart cart = shoppingCartRepository.findById(cartItemDTO.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(cartItemDTO.getQuantity())));

        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return cartItemMapper.toDTO(savedCartItem);
    }

    @Override
    public List<CartItemDTO> getCartItemsByUser(Long userId) {
        return cartItemRepository.findByCartUserId(userId).stream()
                .map(cartItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setPrice(cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItemDTO.getQuantity())));

        CartItem updatedCartItem = cartItemRepository.save(cartItem);
        return cartItemMapper.toDTO(updatedCartItem);
    }

    @Override
    public void removeCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public void clearCart(Long userId) {
        cartItemRepository.deleteByCartUserId(userId);
    }
}
