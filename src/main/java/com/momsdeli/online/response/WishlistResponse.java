package com.momsdeli.online.response;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Data
public class WishlistResponse {

    private Long id;
    private String name;
    private List<WishlistItemResponse> wishlistItems;

}
