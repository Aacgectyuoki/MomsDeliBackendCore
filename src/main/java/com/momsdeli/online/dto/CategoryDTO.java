package com.momsdeli.online.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @JsonProperty("name")
    private String name;

    @JsonProperty("products")
    private List<ProductDTO> products;
}
