package com.momsdeli.online.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class CartItemDTO {

    private Long id;
    private String productName; // This could be the product name or a ProductDTO
    private int quantity;
    private BigDecimal price;
    private Long productId; // The ID of the product being added to the cart
    private Long cartId;    // The ID of the cart
}
