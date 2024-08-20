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
public class PaymentRequest {

    @NotBlank
    private String order; // This could be the order ID

    @NotBlank
    private String paymentMethod;

    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String paymentStatus;

    @NotBlank
    private String transactionId;
}