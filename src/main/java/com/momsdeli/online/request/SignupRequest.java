package com.momsdeli.online.request;

import lombok.Data;

/**
 * Request payload for user signup.
 */
@Data
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String role; // Ensure this field exists

}
