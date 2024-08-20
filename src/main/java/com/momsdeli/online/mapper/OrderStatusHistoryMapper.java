package com.momsdeli.online.mapper;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import com.momsdeli.online.dto.OrderStatusHistoryDTO;
import com.momsdeli.online.model.OrderStatusHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderStatusHistoryMapper {

    OrderStatusHistoryMapper INSTANCE = Mappers.getMapper(OrderStatusHistoryMapper.class);

    @Mapping(source = "order.id", target = "order")
    OrderStatusHistoryDTO toDTO(OrderStatusHistory orderStatusHistory);

    @Mapping(source = "order", target = "order.id")
    OrderStatusHistory toEntity(OrderStatusHistoryDTO orderStatusHistoryDTO);

    List<OrderStatusHistoryDTO> toDTOs(List<OrderStatusHistory> statusHistoryList);

    List<OrderStatusHistory> toEntities(List<OrderStatusHistoryDTO> statusHistoryDTOList);
}
