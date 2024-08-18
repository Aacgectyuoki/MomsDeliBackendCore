package com.momsdeli.online.request;

import lombok.*;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {

    private Long userId;

    private List<CartItemRequest> cartItems;

    public CartItemRequest getCartItemRequest(Long productId) {
        if (cartItems != null) {
            for (CartItemRequest item : cartItems) {
                if (item.getProductId().equals(productId)) {
                    return item; // Return the item that matches the criteria
                }
            }
        }
        return null; // Or throw an exception if no matching item is found
    }


}
