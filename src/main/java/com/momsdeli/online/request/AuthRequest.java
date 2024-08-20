package com.momsdeli.online.request;

import lombok.Data;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

@Data
public class AuthRequest {

    private String username;
    private String password;
}
