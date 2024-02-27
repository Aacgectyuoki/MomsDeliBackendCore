/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:15 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDTO {

    private Long id;
    private String description;
    @NotNull
    @PositiveOrZero
    private Double price;
    private Double discountedPrice;
    private Double discountedPercent;
    @NotNull
    @PositiveOrZero
    private Integer quantity;
    private String imageUrl;
    private Double numRatings;
    private Long categoryId;
    private LocalDateTime createdAt;
}
