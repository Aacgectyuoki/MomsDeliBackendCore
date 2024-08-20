package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class PaymentMethodRequest {


    @NotBlank
    private String methodType;

    @NotBlank
    private String provider;

    @NotBlank
    private String accountNumber;

    private String expiryDate;
}
