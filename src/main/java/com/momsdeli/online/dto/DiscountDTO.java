package com.momsdeli.online.dto;

import lombok.Data;

import java.math.BigDecimal;

import java.time.LocalDate;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class DiscountDTO {

    private Long id;
    private String code;           // Discount code (e.g., SAVE10)
    private BigDecimal percentage; // Discount percentage
    private LocalDate startDate;   // Start date of the discount
    private LocalDate endDate;     // End date of the discount
    private boolean active;        // Whether the discount is currently active
}
