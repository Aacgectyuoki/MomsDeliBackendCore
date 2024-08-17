package com.momsdeli.online.request;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class CategoryRequest {

    private String name;

    private List<ProductRequest> products;
}
