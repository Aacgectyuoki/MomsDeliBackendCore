package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ShippingAddressDTO;
import com.momsdeli.online.model.ShippingAddress;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShippingAddressMapper {

    ShippingAddressMapper INSTANCE = Mappers.getMapper(ShippingAddressMapper.class);

    ShippingAddressDTO shippingAddressToShippingAddressDTO(ShippingAddress shippingAddress);

    ShippingAddress shippingAddressDTOToShippingAddress(ShippingAddressDTO shippingAddressDTO);

    void updateShippingAddressFromDTO(ShippingAddressDTO dto, @MappingTarget ShippingAddress entity);
}
