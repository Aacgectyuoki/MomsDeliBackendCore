/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:20 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.service.impl;

import com.momsdeli.online.config.JwtProvider;
import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.exceptions.UserException;
import com.momsdeli.online.mapper.UserMapper;
import com.momsdeli.online.model.User;
import com.momsdeli.online.repository.UserRepository;
import com.momsdeli.online.service.UserService;
//import jakarta.transaction.Transactional;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProvider jwtProvider;

    @Transactional(readOnly = true)
    @Override
    public UserDTO getUserDtoById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);  // Assumes that UserMapper has a toUserDTO method
    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO findUserById(Long id) throws UserException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));
        return UserMapper.toDTO(user);  // Correcting to use toUserDTO
    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO findUserProfileByJwt(String jwt) throws UserException {
        try {
            String email = jwtProvider.getEmailFromToken(jwt);  // Decode JWT to get email

            User user = userRepository.findByEmail(email);  // This method now returns User or null
            if (user == null) {
                throw new UserException("User not found with email: " + email);
            }

            return UserMapper.toDTO(user);  // Ensure UserMapper has a toDTO method that matches this call
        } catch (Exception e) {
            throw new UserException("Error processing JWT: " + e.getMessage(), e);
        }
    }


//    @Transactional(readOnly = true)
//    @Override
//    public UserDTO findUserProfileByJwt(String jwt) throws UserException {
//        try {
//            String userId = jwtProvider.getUserIdFromToken(jwt);  // Use JwtProvider to decode JWT
//            Long id = Long.parseLong(userId);
//
//            User user = userRepository.findById(id)
//                    .orElseThrow(() -> new UserException("User not found with id: " + id));
//
//            return userMapper.toUserDTO(user);
//        } catch (Exception e) {
//            throw new UserException("Error processing JWT: " + e.getMessage(), e);
//        }
//    }

//    public UserDTO findUserById(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return userMapper.toUserDTO(user);
//    }
}
//@Service
//public class UserServiceImpl {
//
//}
