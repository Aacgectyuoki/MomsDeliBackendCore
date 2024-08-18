package com.momsdeli.online.controller;

import com.momsdeli.online.request.OrderItemRequest;
import com.momsdeli.online.response.OrderItemResponse;
import com.momsdeli.online.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItemResponse addOrderItem(@RequestBody OrderItemRequest request) {
        return orderItemService.addOrderItem(request);
    }

    @PutMapping("/{id}")
    public OrderItemResponse updateOrderItem(@PathVariable Long id, @RequestBody OrderItemRequest request) {
        return orderItemService.updateOrderItem(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }

    @GetMapping("/{id}")
    public OrderItemResponse getOrderItem(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @GetMapping
    public List<OrderItemResponse> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }
}
