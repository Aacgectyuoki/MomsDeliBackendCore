package com.momsdeli.online.mapper;


import com.momsdeli.online.dto.OrderItemDTO;
import com.momsdeli.online.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(source = "product.name", target = "productName")
    OrderItemDTO toDTO(OrderItem orderItem);

    @Mapping(source = "productName", target = "product.name")
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toDTOs(List<OrderItem> orderItems);

    List<OrderItem> toEntities(List<OrderItemDTO> orderItemDTOs);
}
