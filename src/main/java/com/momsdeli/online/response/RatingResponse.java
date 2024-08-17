package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class RatingResponse {


    private Long id;

    private int ratingValue;

    private ProductResponse product; // Full object

    private UserResponse user; // Full object
}
