package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class CartItemRequest {

    private Long productId;

    private int quantity;

    private Long cartId;
}
