package com.momsdeli.online.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private String category; // This could be the category name or a CategoryDTO
    private String imageUrl;
}
