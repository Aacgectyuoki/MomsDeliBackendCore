package com.momsdeli.online.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class OrderItemDTO {

    private Long id;
    private String productName;
    private int quantity;
    private BigDecimal price;
}
