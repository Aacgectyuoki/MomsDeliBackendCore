package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Comment is mandatory")
    @JsonProperty("comment")
    private String comment;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    @JsonProperty("rating")
    private int rating;

    @NotNull(message = "Product is mandatory")
    @JsonProperty("product")
    private ProductDTO product;

    @NotNull(message = "User is mandatory")
    @JsonProperty("user")
    private UserDTO user;
}
