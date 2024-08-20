package com.momsdeli.online.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class OrderResponse {


    private Long id;
    private String user;
    private BigDecimal totalPrice;
    private String status;
    private List<OrderItemResponse> orderItems;
}
