package com.momsdeli.online.response;

import lombok.Data;

import java.util.List;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private String role;

    private String firstName;

    private String lastName;

    private CartResponse cart;

    private List<OrderResponse> orders;

    private List<RatingResponse> ratings;
}
