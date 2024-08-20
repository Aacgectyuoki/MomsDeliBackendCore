package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class ReviewResponse {

    private Long id;
    private String productName;
    private String username;
    private int rating;
    private String comment;
}
