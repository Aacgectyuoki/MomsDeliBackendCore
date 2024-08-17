package com.momsdeli.online.response;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class ProductResponse {

    private Long id;

    private String name;

    private String description;

    private double price;

    private String imageUrl;

    private CategoryResponse category;

    private List<ReviewResponse> reviews;

    private List<RatingResponse> ratings;

    private List<DiscountResponse> discounts;
}
