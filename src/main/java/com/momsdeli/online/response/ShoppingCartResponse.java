package com.momsdeli.online.response;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class ShoppingCartResponse {

    private Long id;
    private String user; // This could be the username
    private List<CartItemResponse> cartItems;
}
