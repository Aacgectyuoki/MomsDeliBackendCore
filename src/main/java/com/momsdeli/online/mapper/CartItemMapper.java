package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.CartItemDTO;
import com.momsdeli.online.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CartMapper.class, ProductMapper.class})
public interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

//    @Mapping(source = "cart.id", target = "cartId")
//    @Mapping(source = "product.id", target = "productId")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    CartItemDTO cartItemToCartItemDTO(CartItem cartItem);

//    @Mapping(source = "cartId", target = "cart.id")
//    @Mapping(source = "productId", target = "product.id")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CartItem cartItemDTOToCartItem(CartItemDTO cartItemDTO);

    void updateCartItemFromDTO(CartItemDTO dto, @MappingTarget CartItem entity);

    List<CartItemDTO> cartItemToCartItemDTOList(List<CartItem> cartItems);
}
