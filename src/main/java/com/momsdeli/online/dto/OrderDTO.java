package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Order date is mandatory")
    @JsonProperty("order_date")
    private Date orderDate;

    @NotBlank(message = "Status is mandatory")
    @JsonProperty("status")
    private String status;

    @NotNull(message = "User is mandatory")
    @JsonProperty("user")
    private UserDTO user;

    @JsonProperty("order_items")
    private List<OrderItemDTO> orderItems;

    @JsonProperty("payment")
    private PaymentDTO payment;

    @JsonProperty("shipping_address")
    private ShippingAddressDTO shippingAddress;
}
