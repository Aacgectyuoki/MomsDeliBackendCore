package com.momsdeli.online.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class WishlistRequest {


    @NotBlank
    private String name;

    @NotNull
    private List<WishlistItemRequest> wishlistItems;
}
