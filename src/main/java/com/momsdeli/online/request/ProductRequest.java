package com.momsdeli.online.request;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class ProductRequest {

    private String name;

    private String description;

    private double price;

    private String imageUrl;

    private Long categoryId;

    private List<ReviewRequest> reviews;

    private List<RatingRequest> ratings;

    private List<DiscountRequest> discounts;
}
