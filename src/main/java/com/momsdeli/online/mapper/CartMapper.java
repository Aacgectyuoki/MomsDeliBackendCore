package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CartDTO;
import com.momsdeli.online.model.Cart;
import com.momsdeli.online.model.CartItem;
import com.momsdeli.online.request.CartRequest;
import com.momsdeli.online.response.CartItemResponse;
import com.momsdeli.online.response.CartResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, OrderMapper.class, CartItemMapper.class})
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

//    @Mapping(target = "user", source = "user", qualifiedByName = "mapUser")
//    @Mapping(target = "orderItems", source = "orderItems", qualifiedByName = "mapOrderItems")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    CartDTO cartToCartDTO(Cart cart);

//    @Mapping(target = "user", source = "user", qualifiedByName = "mapUser")
//    @Mapping(target = "orderItems", source = "orderItems", qualifiedByName = "mapOrderItems")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Cart cartDTOToCart(CartDTO cartDTO);

    void updateCartFromDTO(CartDTO dto, @MappingTarget Cart entity);

    CartItem requestToCartItem(CartRequest request);

    CartItemResponse cartItemToResponse(CartItem cartItem);

    Cart requestToCart(CartRequest request);

    CartResponse cartToResponse(Cart cart);
}
