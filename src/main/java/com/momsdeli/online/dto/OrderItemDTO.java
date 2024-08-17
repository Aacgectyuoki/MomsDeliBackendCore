package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemDTO {

    @JsonProperty("id")
    private Long id;

    @Min(value = 1, message = "Quantity must be at least 1")
    @JsonProperty("quantity")
    private int quantity;

    @NotNull(message = "Price is mandatory")
    @JsonProperty("price")
    private double price;

    @NotNull(message = "Product is mandatory")
    @JsonProperty("product")
    private ProductDTO product;

    @NotNull(message = "Order is mandatory")
    @JsonProperty("order")
    private OrderDTO order;
}
