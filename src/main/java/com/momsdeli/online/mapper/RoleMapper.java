package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.RoleDTO;
import com.momsdeli.online.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);

    List<RoleDTO> toDTOs(List<Role> roles);

    List<Role> toEntities(List<RoleDTO> roleDTOs);
}
