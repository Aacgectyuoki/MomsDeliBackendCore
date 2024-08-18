package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.OrderDTO;
import com.momsdeli.online.model.Order;
import com.momsdeli.online.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, OrderItemMapper.class, PaymentMapper.class, ShippingAddressMapper.class})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

//    @Mapping(source = "user.id", target = "userId")
//    @Mapping(target = "orderItems", source = "orderItems", qualifiedByName = "mapOrderItems")
//    @Mapping(target = "payment", source = "payment", qualifiedByName = "mapPayment")
//    @Mapping(target = "shippingAddress", source = "shippingAddress", qualifiedByName = "mapShippingAddress")
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    OrderDTO orderToOrderDTO(Order order);

//    @Mapping(source = "userId", target = "user.id")
//    @Mapping(target = "orderItems", source = "orderItems", qualifiedByName = "mapOrderItems")
//    @Mapping(target = "payment", source = "payment", qualifiedByName = "mapPayment")
//    @Mapping(target = "shippingAddress", source = "shippingAddress", qualifiedByName = "mapShippingAddress")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Order orderDTOToOrder(OrderDTO orderDTO);

    void updateOrderFromDTO(OrderRequest request, @MappingTarget Order entity);
//    void updateOrderFromDTO(OrderRequest dto, @MappingTarget Order entity);

    Object orderToResponse(Order order);

    Order requestToOrder(OrderRequest request);
}
