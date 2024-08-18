package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.OrderItemDTO;
import com.momsdeli.online.model.OrderItem;
import com.momsdeli.online.request.OrderItemRequest;
import com.momsdeli.online.response.OrderItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductMapper.class, OrderMapper.class})
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

//    @Mapping(target = "product", source = "product")
//    @Mapping(target = "order", source = "order")
//    @Mapping(target = "createdAt", ignore = true) // If 'createdAt' doesn't exist in DTO, ignore it
//    @Mapping(target = "updatedAt", ignore = true) // If 'updatedAt' doesn't exist in DTO, ignore it
    OrderItemDTO orderItemToOrderItemDTO(OrderItem orderItem);

//    @Mapping(target = "product", source = "product")
//    @Mapping(target = "order", source = "order")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OrderItem orderItemDTOToOrderItem(OrderItemDTO orderItemDTO);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateOrderItemFromDTO(OrderItemRequest dto, @MappingTarget OrderItem entity);

    OrderItem requestToOrderItem(OrderItemRequest request);

    OrderItemResponse orderItemToResponse(OrderItem orderItem);
}

