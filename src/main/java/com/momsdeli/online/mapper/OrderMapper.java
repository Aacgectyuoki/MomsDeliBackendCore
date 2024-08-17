package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.OrderDTO;
import com.momsdeli.online.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToOrderDTO(Order order);

    Order orderDTOToOrder(OrderDTO orderDTO);

    void updateOrderFromDTO(OrderDTO dto, @MappingTarget Order entity);
}
