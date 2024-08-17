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
}
