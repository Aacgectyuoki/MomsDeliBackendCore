package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class ReviewResponse {

    private Long id;

    private String comment;

    private int rating;

    private ProductResponse product; // Full object

    private UserResponse user; // Full object
}
