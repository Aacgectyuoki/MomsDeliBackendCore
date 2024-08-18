package com.momsdeli.online.request;

import lombok.*;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class CartRequest {
    private Long id;
    private Long userId;
    private List<CartItemRequest> cartItems;

    public Long getCartId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }
}
