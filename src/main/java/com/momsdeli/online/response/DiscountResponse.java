package com.momsdeli.online.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class DiscountResponse {


    private Long id;
    private String productName;
    private BigDecimal discountPercent;
    private LocalDate startDate;
    private LocalDate endDate;
}
