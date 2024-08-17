package com.momsdeli.online.response;

import lombok.Data;

import java.util.Date;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class PaymentResponse {

    private Long id;

    private String paymentType;

    private String provider;

    private double amount;

    private Date paymentDate;

    private OrderResponse order;
}
