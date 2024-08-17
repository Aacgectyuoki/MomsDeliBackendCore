package com.momsdeli.online.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class OrderRequest {

    private Date orderDate;

    private String status;

    private Long userId;

    private List<OrderItemRequest> orderItems;

    private PaymentRequest payment;

    private ShippingAddressRequest shippingAddress;
}
