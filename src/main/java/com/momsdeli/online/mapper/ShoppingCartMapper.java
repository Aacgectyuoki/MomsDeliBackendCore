package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
import com.momsdeli.online.dto.ShoppingCartDTO;
import com.momsdeli.online.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface ShoppingCartMapper {

    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    @Mapping(source = "user.username", target = "user")
    ShoppingCartDTO toDTO(ShoppingCart shoppingCart);

    @Mapping(source = "user", target = "user.username")
    ShoppingCart toEntity(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCartDTO> toDTOs(List<ShoppingCart> shoppingCarts);
    List<ShoppingCart> toEntities(List<ShoppingCartDTO> shoppingCartDTOs);
}
