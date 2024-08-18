package com.momsdeli.online.service;

import com.momsdeli.online.mapper.OrderMapper;
import com.momsdeli.online.model.Order;
import com.momsdeli.online.repository.OrderRepository;
import com.momsdeli.online.request.OrderRequest;
import com.momsdeli.online.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

//    public OrderResponse createOrder(OrderRequest request) {
//        Order order = orderMapper.requestToOrder(request);
//        order = orderRepository.save(order);
//        return orderMapper.orderToResponse(order);
//    }

    public OrderResponse addOrder(OrderRequest request) {
        Order order = orderMapper.requestToOrder(request);
        order = orderRepository.save(order);
        return (OrderResponse) orderMapper.orderToResponse(order);
    }

    public OrderResponse updateOrder(Long id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderMapper.updateOrderFromDTO(request, order);
        order = orderRepository.save(order);
        return (OrderResponse) orderMapper.orderToResponse(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return (OrderResponse) orderMapper.orderToResponse(order);
    }

    public List<Object> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::orderToResponse)
                .collect(Collectors.toList());
    }
}
