package com.momsdeli.online.service;

import com.momsdeli.online.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long id);

    List<OrderDTO> getAllOrders();

    OrderDTO updateOrder(Long id, OrderDTO orderDTO);

    void deleteOrder(Long id);

    List<OrderDTO> getUserOrders(Long userId);

    OrderDTO changeOrderStatus(Long id, String status);

    String trackOrder(Long id);

    List<String> getOrderHistory(Long id);

    OrderDTO addOrUpdatePayment(Long id, OrderDTO orderDTO);
}
