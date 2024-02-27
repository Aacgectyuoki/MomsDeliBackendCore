/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/28/2024$
 * Time: 12:12 AM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String message;

}
