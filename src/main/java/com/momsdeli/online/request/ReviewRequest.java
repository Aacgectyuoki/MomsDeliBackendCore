package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class ReviewRequest {

    private String comment;

    private int rating;

    private Long productId; // Reference by ID

    private Long userId; // Reference by ID
}
