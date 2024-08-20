package com.momsdeli.online.dto;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String role; // This could be the role name
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address; // Y
    private String password;

}
