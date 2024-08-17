package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    void updateUserFromDTO(UserDTO dto, @MappingTarget User entity);
}
