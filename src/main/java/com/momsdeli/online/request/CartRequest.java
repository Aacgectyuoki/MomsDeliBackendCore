package com.momsdeli.online.request;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class CartRequest {

    private Long userId;

    private List<CartItemRequest> cartItems;
}
