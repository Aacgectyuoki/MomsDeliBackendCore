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
    private String productName; // This could be the product name or a ProductDTO
    private BigDecimal discountPercent;
    private LocalDate startDate;
    private LocalDate endDate;
}
