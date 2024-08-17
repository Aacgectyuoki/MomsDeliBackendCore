package com.momsdeli.online.response;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */
@Data
public class CategoryResponse {

    private Long id;

    private String name;

    private List<ProductResponse> products;
}
