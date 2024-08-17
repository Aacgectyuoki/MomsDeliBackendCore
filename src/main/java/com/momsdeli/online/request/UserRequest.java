package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 16/08/2024
 */

@Data
public class UserRequest {

    private String username;

    private String password;

    private String email;

    private String role;

    private String firstName;

    private String lastName;
}
