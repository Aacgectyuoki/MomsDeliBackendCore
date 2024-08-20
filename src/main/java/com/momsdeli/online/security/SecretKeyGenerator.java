package com.momsdeli.online.security;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256-bit key
        secureRandom.nextBytes(key);
        String jwtSecret = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated JWT Secret Key: " + jwtSecret);
    }
}
