package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class OrderItemResponse {

    private Long id;

    private int quantity;

    private double price;

    private ProductResponse product;

    private OrderResponse order;
}
