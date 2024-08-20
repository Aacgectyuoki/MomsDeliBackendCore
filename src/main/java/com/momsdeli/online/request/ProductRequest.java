package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
public class ProductRequest {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer stockQuantity;

    @NotBlank
    private String category; // This could be the category name

    private String imageUrl;
}
