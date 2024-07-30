/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:30 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.controller;

import com.momsdeli.online.config.JwtProvider;
import com.momsdeli.online.request.LoginRequest;
import com.momsdeli.online.response.AuthResponse;
import com.momsdeli.online.exceptions.UserException;
import com.momsdeli.online.model.User;
import com.momsdeli.online.repository.UserRepository;
import com.momsdeli.online.service.impl.CustomUserServiceImplementation;
import com.momsdeli.online.utils.MomsDeliUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserServiceImplementation customUserServiceImplementation;

    public AuthController(UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, CustomUserServiceImplementation customUserServiceImplementation) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.customUserServiceImplementation = customUserServiceImplementation;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        User isEmailExist = userRepository.findByEmail(email);

        if (isEmailExist != null) {
            throw new UserException("Email is already used with another account");
        }

        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setFirstName(firstName);
        createdUser.setLastName(lastName);
        User savedUser = userRepository.save(createdUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String generateToken = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(generateToken, MomsDeliUtils.SIGNUP_SUCCESS);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authentication authentication = authentication(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String generateToken = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(generateToken, MomsDeliUtils.SIGNING_SUCCESS);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);

    }

    private Authentication authentication(String email, String password) {

        UserDetails userDetails = customUserServiceImplementation.loadUserByUsername(email);

        if (StringUtils.isBlank(email)) {
            throw new BadCredentialsException("Invalid username");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
