package com.momsdeli.online.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class WishlistDTO {

    private Long id;
    private String user; // This could be the username or a UserDTO
    private String name;
    private List<WishlistItemDTO> wishlistItems;
}
