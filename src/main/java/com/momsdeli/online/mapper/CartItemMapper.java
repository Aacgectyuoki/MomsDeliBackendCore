package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.CartItemDTO;
import com.momsdeli.online.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    @Mapping(source = "product.name", target = "productName")
    CartItemDTO toDTO(CartItem cartItem);

    @Mapping(source = "productName", target = "product.name")
    CartItem toEntity(CartItemDTO cartItemDTO);

    List<CartItemDTO> toDTOs(List<CartItem> cartItems);

    List<CartItem> toEntities(List<CartItemDTO> cartItemDTOs);
}
