package com.momsdeli.online.mapper;


import com.momsdeli.online.dto.OrderDTO;
import com.momsdeli.online.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "user.username", target = "user")
    OrderDTO toDTO(Order order);

    @Mapping(source = "user", target = "user.username")
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDTOs(List<Order> orders);
    List<Order> toEntities(List<OrderDTO> orderDTOs);
}
