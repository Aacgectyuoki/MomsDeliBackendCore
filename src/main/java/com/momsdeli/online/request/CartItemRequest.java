package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class CartItemRequest {

    @NotBlank
    private String productName;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;
}
