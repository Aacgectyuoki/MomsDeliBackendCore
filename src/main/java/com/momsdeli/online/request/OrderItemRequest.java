package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class OrderItemRequest {

    private int quantity;

    private double price;

    private Long productId;

    private Long orderId;

}
