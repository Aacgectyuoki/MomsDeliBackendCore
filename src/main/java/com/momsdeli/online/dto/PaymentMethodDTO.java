package com.momsdeli.online.dto;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class PaymentMethodDTO {

    private Long id;
    private String methodType; // e.g., Credit Card, PayPal
    private String provider; // e.g., Visa, MasterCard
    private String accountNumber;
    private String expiryDate;
}
