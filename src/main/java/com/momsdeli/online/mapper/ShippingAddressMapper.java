package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.ShippingAddressDTO;
import com.momsdeli.online.model.ShippingAddress;
import com.momsdeli.online.request.ShippingAddressRequest;
import com.momsdeli.online.response.ShippingAddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderMapper.class})
public interface ShippingAddressMapper {

    ShippingAddressMapper INSTANCE = Mappers.getMapper(ShippingAddressMapper.class);

//    @Mapping(target = "order.id", source = "order.id")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    ShippingAddressDTO shippingAddressToShippingAddressDTO(ShippingAddress shippingAddress);

//    @Mapping(target = "order.id", source = "order.id")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ShippingAddress shippingAddressDTOToShippingAddress(ShippingAddressDTO shippingAddressDTO);

//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//    void updateShippingAddressFromDTO(ShippingAddressDTO dto, @MappingTarget ShippingAddress entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateShippingAddressFromDTO(ShippingAddressRequest request, @MappingTarget ShippingAddress entity);


    ShippingAddressResponse shippingAddressToResponse(ShippingAddress shippingAddress);

    ShippingAddress requestToShippingAddress(ShippingAddressRequest request);
}
