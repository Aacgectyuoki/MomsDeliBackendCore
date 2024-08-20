package com.momsdeli.online.response;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class UserResponse {


    private Long id;
    private String username;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
