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
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private boolean isActive;
    private Integer category;
    private String imageUrl;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private Float averageRating;
}
