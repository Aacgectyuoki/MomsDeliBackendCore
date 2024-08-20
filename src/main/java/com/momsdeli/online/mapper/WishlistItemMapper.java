package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.WishlistItemDTO;
import com.momsdeli.online.model.WishlistItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WishlistItemMapper {

    WishlistItemMapper INSTANCE = Mappers.getMapper(WishlistItemMapper.class);

    @Mapping(source = "product.name", target = "productName")
    WishlistItemDTO toDTO(WishlistItem wishlistItem);

    @Mapping(source = "productName", target = "product.name")
    WishlistItem toEntity(WishlistItemDTO wishlistItemDTO);

    List<WishlistItemDTO> toDTOs(List<WishlistItem> wishlistItems);

    List<WishlistItem> toEntities(List<WishlistItemDTO> wishlistItemDTOs);
}
