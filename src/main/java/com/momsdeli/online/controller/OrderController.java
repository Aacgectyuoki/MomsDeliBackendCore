package com.momsdeli.online.controller;

import com.momsdeli.online.dto.OrderDTO;
import com.momsdeli.online.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 1. Create Order
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    // 2. Get Order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        OrderDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // 3. Get All Orders
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // 4. Update Order
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(id, orderDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    // 5. Delete Order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // 6. Get User Orders
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getUserOrders(@PathVariable Long userId) {
        List<OrderDTO> userOrders = orderService.getUserOrders(userId);
        return ResponseEntity.ok(userOrders);
    }

    // 7. Change Order Status
    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> changeOrderStatus(@PathVariable Long id, @RequestParam String status) {
        OrderDTO updatedOrder = orderService.changeOrderStatus(id, status);
        return ResponseEntity.ok(updatedOrder);
    }

    // 8. Track Order
    @GetMapping("/{id}/track")
    public ResponseEntity<String> trackOrder(@PathVariable Long id) {
        String trackingInfo = orderService.trackOrder(id);
        return ResponseEntity.ok(trackingInfo);
    }

    // 9. Get Order History
    @GetMapping("/{id}/history")
    public ResponseEntity<List<String>> getOrderHistory(@PathVariable Long id) {
        List<String> history = orderService.getOrderHistory(id);
        return ResponseEntity.ok(history);
    }

    // 10. Add or Update Payment for Order
    @PostMapping("/{id}/payment")
    public ResponseEntity<OrderDTO> addOrUpdatePayment(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.addOrUpdatePayment(id, orderDTO);
        return ResponseEntity.ok(updatedOrder);
    }
}
