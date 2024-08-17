package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class RatingRequest {

    private int ratingValue;

    private Long productId; // Reference by ID

    private Long userId; // Reference by ID
}
