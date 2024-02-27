/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 3:22 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static String generateSecretKey(int keyLength) {
        // Generate a secure random byte array
        byte[] randomBytes = new byte[keyLength];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        // Encode the byte array as a Base64 string
        return Base64.getEncoder().encodeToString(randomBytes);
    }

    public static void main(String[] args) {
        // Define the length of the secret key in bytes
        int keyLength = 64;

        // Generate the secret key
        String secretKey = generateSecretKey(keyLength);

        // Print the generated secret key
        System.out.println("Generated Secret Key: " + secretKey);
    }
}
