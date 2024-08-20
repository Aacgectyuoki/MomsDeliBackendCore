package com.momsdeli.online.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class ShoppingCartRequest {


    @NotNull
    private List<CartItemRequest> cartItems;
}
