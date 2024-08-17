package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CartDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "User is mandatory")
    @JsonProperty("user")
    private UserDTO user;

    @JsonProperty("cart_items")
    private List<CartItemDTO> cartItems;
}
