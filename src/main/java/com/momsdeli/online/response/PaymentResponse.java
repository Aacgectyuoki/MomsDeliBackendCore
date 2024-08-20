package com.momsdeli.online.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class PaymentResponse {

    private Long id;
    private String order;
    private String paymentMethod;
    private BigDecimal amount;
    private String paymentStatus;
    private String transactionId;
}
