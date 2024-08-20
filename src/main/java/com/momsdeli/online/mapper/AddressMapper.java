package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.AddressDTO;
import com.momsdeli.online.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO toDTO(Address address);

    Address toEntity(AddressDTO addressDTO);

    List<AddressDTO> toDTOs(List<Address> addresses);

    List<Address> toEntities(List<AddressDTO> addressDTOs);
}
