package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class DiscountRequest {

    @NotBlank
    private String productName;

    @NotNull
    private BigDecimal discountPercent;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
}