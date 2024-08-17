package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CartDTO;
import com.momsdeli.online.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDTO cartToCartDTO(Cart cart);

    Cart cartDTOToCart(CartDTO cartDTO);

    // Method to update an existing entity from a DTO
    void updateCartFromDTO(CartDTO dto, @MappingTarget Cart entity);
}
