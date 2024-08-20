package com.momsdeli.online.request;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserRequest {

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String role; // This could be the role name, e.g., "USER" or "ADMIN"

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 20)
    private String phoneNumber;

    // Address fields could be included here if you want to create/update a user along with their address
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
