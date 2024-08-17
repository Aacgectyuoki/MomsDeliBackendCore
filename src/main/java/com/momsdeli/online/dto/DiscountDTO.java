package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscountDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "Discount value is mandatory")
    @JsonProperty("discount_value")
    private double discountValue; // Percentage or flat value

    @NotNull(message = "Discount type is mandatory")
    @JsonProperty("is_percentage")
    private boolean isPercentage; // True if percentage discount, false if flat discount

    @NotNull(message = "Start date is mandatory")
    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @NotNull(message = "End date is mandatory")
    @JsonProperty("end_date")
    private LocalDateTime endDate;

    @NotNull(message = "Product is mandatory")
    @JsonProperty("product")
    private ProductDTO product;
}
