package com.momsdeli.online.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class PaymentDTO {

    private Long id;
    private String order; // This could be the order ID or an OrderDTO
    private String paymentMethod;
    private BigDecimal amount;
    private String paymentStatus;
    private String transactionId;
}
