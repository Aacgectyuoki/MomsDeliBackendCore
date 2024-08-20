package com.momsdeli.online.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class CartItemResponse {

    private Long id;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
}
