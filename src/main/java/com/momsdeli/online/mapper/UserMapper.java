package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.model.Role;
import com.momsdeli.online.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true) // Ignore password field
    @Mapping(target = "role", expression = "java(mapRolesToRoleName(user.getRoles()))")
    UserDTO toDTO(User user);

    @Mapping(target = "roles", expression = "java(mapRoleNameToRoles(userDTO.getRole()))")
    User toEntity(UserDTO userDTO);

    List<UserDTO> toDTOs(List<User> users);

    List<User> toEntities(List<UserDTO> userDTOs);

    // Helper method to convert Set<Role> to a comma-separated string of role names
    default String mapRolesToRoleName(Set<Role> roles) {
        return roles.stream()
                .map(Role::getRoleName)
                .collect(Collectors.joining(","));
    }

    // Helper method to create a Set<Role> with a single Role based on the role name
    default Set<Role> mapRoleNameToRoles(String roleName) {
        // You can enhance this method to fetch roles from the database if needed.
        Role role = new Role();
        role.setRoleName(roleName);
        return Set.of(role);
    }


}
