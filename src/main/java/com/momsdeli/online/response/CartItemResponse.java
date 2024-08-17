package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class CartItemResponse {


    private Long id;

    private int quantity;

    private ProductResponse product;

    private CartResponse cart;
}
