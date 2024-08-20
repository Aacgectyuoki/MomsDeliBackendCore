package com.momsdeli.online.response;

import lombok.Data;

/**
 * Response payload for user signup.
 */
@Data
public class SignupResponse {

    private Long id;
    private String username;
    private String email;
    private String message;

    public SignupResponse(Long id, String username, String email, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.message = message;
    }
}
