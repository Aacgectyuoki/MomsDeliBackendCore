package com.momsdeli.online.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class DiscountRequest {

    private String name;

    private double discountValue; // Percentage or flat value

    private boolean isPercentage; // True if percentage discount, false if flat discount

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long productId; // Reference by ID


}
