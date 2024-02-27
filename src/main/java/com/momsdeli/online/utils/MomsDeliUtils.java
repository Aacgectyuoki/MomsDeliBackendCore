/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 3:19 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MomsDeliUtils {

    public static final String SECRET_KEY = "6XQwv+F7OZhsV4R3EiWnlZSQeULv2+3qg56UEDjbO3RQ+QCZVcVH+GSFhQCILtJlugFK8fcMXNx3FXBtVA+eDA==";
    public static final String JWT_HEADER = "Authorization";
    public static final List<String> ALLOWED_ORIGINS = Arrays.asList(
            "http://localhost:8080",
            "http://localhost:4200"
    );
    public static final String API_PATH_PATTERN = "/api/**";
    public static final String EMAIL = "email";
    // Expiration duration in milliseconds (24 hours)
    public static final long EXPIRATION_DURATION_MILLIS = 24 * 60 * 60 * 1000L;

    // Expiration duration as a Date object
    public static final Date EXPIRATION_DATE = new Date(System.currentTimeMillis() + EXPIRATION_DURATION_MILLIS);

    public static final String SIGNUP_SUCCESS = "Signup Success";

    public static final String SIGNING_SUCCESS = "Signing Success";
}
