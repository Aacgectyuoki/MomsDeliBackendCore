package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
import com.momsdeli.online.dto.WishlistDTO;
import com.momsdeli.online.model.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WishlistItemMapper.class})
public interface WishlistMapper {

    WishlistMapper INSTANCE = Mappers.getMapper(WishlistMapper.class);

    @Mapping(source = "user.username", target = "user")
    WishlistDTO toDTO(Wishlist wishlist);

    @Mapping(source = "user", target = "user.username")
    Wishlist toEntity(WishlistDTO wishlistDTO);

    List<WishlistDTO> toDTOs(List<Wishlist> wishlists);
    List<Wishlist> toEntities(List<WishlistDTO> wishlistDTOs);
}
