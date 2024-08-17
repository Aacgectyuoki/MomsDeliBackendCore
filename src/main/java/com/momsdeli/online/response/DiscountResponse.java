package com.momsdeli.online.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class DiscountResponse {

    private Long id;

    private String name;

    private double discountValue;

    private boolean isPercentage;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private ProductResponse product;
}
