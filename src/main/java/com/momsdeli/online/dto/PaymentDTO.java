package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Payment type is mandatory")
    @JsonProperty("payment_type")
    private String paymentType;

    @NotBlank(message = "Provider is mandatory")
    @JsonProperty("provider")
    private String provider;

    @NotNull(message = "Amount is mandatory")
    @JsonProperty("amount")
    private double amount;

    @NotNull(message = "Payment date is mandatory")
    @JsonProperty("payment_date")
    private Date paymentDate;

    @NotNull(message = "Order is mandatory")
    @JsonProperty("order")
    private OrderDTO order;
}
