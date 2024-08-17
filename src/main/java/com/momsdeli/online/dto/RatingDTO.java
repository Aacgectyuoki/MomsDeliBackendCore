package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RatingDTO {

    @JsonProperty("id")
    private Long id;

    @Min(value = 1, message = "Rating value must be at least 1")
    @Max(value = 5, message = "Rating value must be at most 5")
    @JsonProperty("rating_value")
    private int ratingValue;

    @NotNull(message = "Product is mandatory")
    @JsonProperty("product")
    private ProductDTO product;

    @NotNull(message = "User is mandatory")
    @JsonProperty("user")
    private UserDTO user;
}
