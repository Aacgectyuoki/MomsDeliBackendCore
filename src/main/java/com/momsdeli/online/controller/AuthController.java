/**
 * @author Shahbaz Khan
 * @date 20/08/2024
 */

package com.momsdeli.online.controller;

import com.momsdeli.online.request.AuthRequest;
import com.momsdeli.online.response.AuthResponse;
import com.momsdeli.online.response.RefreshTokenResponse;
import com.momsdeli.online.security.JwtUtil;
import com.momsdeli.online.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        AuthResponse response = new AuthResponse(
                accessToken,
                refreshToken,
                3600
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refreshAuthToken(@RequestBody String refreshToken) {
        try {
            if (jwtUtil.validateRefreshToken(refreshToken)) {
                String username = jwtUtil.extractUsername(refreshToken);
                log.info("Username extracted from refresh token: {}", username);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                String newAccessToken = jwtUtil.generateToken(userDetails);
                RefreshTokenResponse response = new RefreshTokenResponse(newAccessToken, refreshToken, 3600);
                log.info("New access token generated for user: {}", username);
                return ResponseEntity.ok(response);
            } else {
                log.warn("Invalid refresh token provided");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            log.error("Error occurred while processing refresh token", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
