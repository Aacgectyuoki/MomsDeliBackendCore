package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @NotNull(message = "Price is mandatory")
    @JsonProperty("price")
    private double price;

    @JsonProperty("product_image_url")
    private String imageUrl;

    @NotNull(message = "Category is mandatory")
    @JsonProperty("category")
    private CategoryDTO category;

    @JsonProperty("reviews")
    private List<ReviewDTO> reviews;

    @JsonProperty("ratings")
    private List<RatingDTO> ratings;

    @JsonProperty("discounts")
    private List<DiscountDTO> discounts;
}
