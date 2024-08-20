package com.momsdeli.online.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class ReviewRequest {

    @NotBlank
    private String productName;

    @NotBlank
    private String username;

    @Min(1)
    @Max(5)
    private int rating;

    private String comment;
}