package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.model.User;
import com.momsdeli.online.request.UserRequest;
import com.momsdeli.online.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderMapper.class, CartItemMapper.class, RatingMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(target = "orders", source = "orders", qualifiedByName = "mapOrders")
//    @Mapping(target = "cartItems", source = "cartItems", qualifiedByName = "mapCartItems")
//    @Mapping(target = "ratings", source = "ratings", qualifiedByName = "mapRatings")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    UserDTO userToUserDTO(User user);

//    @Mapping(target = "orders", source = "orders", qualifiedByName = "mapOrders")
//    @Mapping(target = "cartItems", source = "cartItems", qualifiedByName = "mapCartItems")
//    @Mapping(target = "ratings", source = "ratings", qualifiedByName = "mapRatings")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User userDTOToUser(UserDTO userDTO);

    void updateUserFromDTO(UserRequest dto, @MappingTarget User entity);

    UserResponse userToResponse(User user);

    User requestToUser(UserRequest request);
}
