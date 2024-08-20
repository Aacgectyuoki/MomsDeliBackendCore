package com.momsdeli.online.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shahbaz Khan
 * @date 20/08/2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenResponse {

    private String accessToken;
    private String refreshToken;
    private int expiresIn;


}
