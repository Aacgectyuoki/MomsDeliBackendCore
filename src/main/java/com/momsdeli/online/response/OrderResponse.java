package com.momsdeli.online.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class OrderResponse {

    private Long id;

    private Date orderDate;

    private String status;

    private UserResponse user;

    private List<OrderItemResponse> orderItems;

    private PaymentResponse payment;

    private ShippingAddressResponse shippingAddress;
}
