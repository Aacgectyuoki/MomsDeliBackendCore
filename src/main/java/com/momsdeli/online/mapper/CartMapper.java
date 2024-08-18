package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CartDTO;
import com.momsdeli.online.model.Cart;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.request.CartItemRequest;
import com.momsdeli.online.request.CartRequest;
import com.momsdeli.online.response.CartItemResponse;
import com.momsdeli.online.response.CartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring") // Ensure this is a Spring-managed bean
public interface CartMapper {

    CartDTO cartToCartDTO(Cart cart);

    Cart cartDTOToCart(CartDTO cartDTO);

    Cart requestToCart(CartRequest request);

    CartResponse cartToResponse(Cart cart);

    CartItemResponse cartItemToResponse(CartItem cartItem);

    CartItem requestToCartItem(CartItemRequest request); // Changed parameter to CartItemRequest

    // Method to update an existing entity from a DTO
    void updateCartFromDTO(CartDTO dto, @MappingTarget Cart entity);
}