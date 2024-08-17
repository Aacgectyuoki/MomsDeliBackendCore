package com.momsdeli.online.request;

import lombok.Data;

import java.util.Date;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class PaymentRequest {


    private String paymentType;

    private String provider;

    private double amount;

    private Date paymentDate;

    private Long orderId;
}
