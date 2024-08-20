package com.momsdeli.online.security;

import java.util.Base64;

/**
 * @author Shahbaz Khan
 * @date 20/08/2024
 */
public class DecodeSecretKey {
    public static void main(String[] args) {
        String base64Secret = "EWhIuT9a9MDpoBQ1cVM8X/yoQ0KsoxOt8iclUnxfrD4=";
        byte[] decodedKey = Base64.getDecoder().decode(base64Secret);
        System.out.println("Decoded Secret Key: " + new String(decodedKey));
    }
}