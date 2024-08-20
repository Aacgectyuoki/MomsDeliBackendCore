package com.momsdeli.online.service;

import com.momsdeli.online.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO);  // Register a new user

    UserDTO getUserById(Long id);  // Get user by ID

    UserDTO getUserByUsername(String username);  // Get user by username

    List<UserDTO> getAllUsers();  // Get all users

    UserDTO updateUser(Long id, UserDTO userDTO);  // Update user information

    void deleteUser(Long id);  // Delete user by ID
}
