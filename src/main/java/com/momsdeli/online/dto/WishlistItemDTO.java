package com.momsdeli.online.dto;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class WishlistItemDTO {
    private Long id;
    private String productName; // This could be the product name or a ProductDTO
}