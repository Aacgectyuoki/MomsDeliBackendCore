package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.OrderItemDTO;
import com.momsdeli.online.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemDTO orderItemToOrderItemDTO(OrderItem orderItem);

    OrderItem orderItemDTOToOrderItem(OrderItemDTO orderItemDTO);

    void updateOrderItemFromDTO(OrderItemDTO dto, @MappingTarget OrderItem entity);
}
