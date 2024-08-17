package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartItemDTO {

    @JsonProperty("id")
    private Long id;

    @Min(value = 1, message = "Quantity must be at least 1")
    @JsonProperty("quantity")
    private int quantity;

    @NotNull(message = "Product is mandatory")
    @JsonProperty("product")
    private ProductDTO product;

    @NotNull(message = "Cart is mandatory")
    @JsonProperty("cart")
    private CartDTO cart;
}
