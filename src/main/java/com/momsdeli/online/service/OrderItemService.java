package com.momsdeli.online.service;

import com.momsdeli.online.dto.OrderItemDTO;
import com.momsdeli.online.mapper.OrderItemMapper;
import com.momsdeli.online.model.OrderItem;
import com.momsdeli.online.repository.OrderItemRepository;
import com.momsdeli.online.request.OrderItemRequest;
import com.momsdeli.online.response.OrderItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    public OrderItemResponse addOrderItem(OrderItemRequest request) {
        OrderItem orderItem = orderItemMapper.requestToOrderItem(request);
        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.orderItemToResponse(orderItem);
    }

    public OrderItemResponse updateOrderItem(Long id, OrderItemRequest request) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item not found"));
        orderItemMapper.updateOrderItemFromDTO(request, orderItem);
        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.orderItemToResponse(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    public OrderItemResponse getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item not found"));
        return orderItemMapper.orderItemToResponse(orderItem);
    }

    public List<OrderItemResponse> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::orderItemToResponse)
                .collect(Collectors.toList());
    }
}
