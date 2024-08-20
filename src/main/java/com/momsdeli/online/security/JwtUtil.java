package com.momsdeli.online.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private long tokenValidity;

    @Value("${jwt.refresh.token.validity}")
    private long refreshTokenValidity;


    // Decode the Base64-encoded secret key
    private byte[] getDecodedSecret() {
        byte[] decodedSecret = Base64.getDecoder().decode(secret);
        System.out.println("Decoded Secret: " + Base64.getEncoder().encodeToString(decodedSecret));  // Log the decoded secret
        return decodedSecret;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidity * 1000))
                .signWith(SignatureAlgorithm.HS256, getDecodedSecret())  // Use the decoded secret
                .compact();
    }


    public String generateRefreshToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenValidity * 1000))
                .signWith(SignatureAlgorithm.HS256, getDecodedSecret())
                .compact();
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getDecodedSecret())  // Use the decoded secret
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Boolean validateRefreshToken(String refreshToken) {
        return !isTokenExpired(refreshToken); // Validate only by expiration for simplicity
    }
}
