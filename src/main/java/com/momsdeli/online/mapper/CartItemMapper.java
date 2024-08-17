package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CartItemDTO;
import com.momsdeli.online.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    CartItemDTO cartItemToCartItemDTO(CartItem cartItem);

    CartItem cartItemDTOToCartItem(CartItemDTO cartItemDTO);

    // Method to update an existing entity from a DTO
    void updateCartItemFromDTO(CartItemDTO dto, @MappingTarget CartItem entity);
}
