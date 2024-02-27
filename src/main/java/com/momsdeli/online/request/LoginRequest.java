/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/28/2024$
 * Time: 2:47 AM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
