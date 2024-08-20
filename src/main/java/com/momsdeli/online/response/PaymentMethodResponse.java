package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class PaymentMethodResponse {

    private Long id;
    private String methodType;
    private String provider;
    private String accountNumber;
    private String expiryDate;
}
