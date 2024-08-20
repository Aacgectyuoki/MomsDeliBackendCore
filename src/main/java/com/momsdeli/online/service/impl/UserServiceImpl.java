package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.mapper.UserMapper;
import com.momsdeli.online.model.Role;
import com.momsdeli.online.model.User;
import com.momsdeli.online.repository.RoleRepository;
import com.momsdeli.online.repository.UserRepository;
import com.momsdeli.online.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO registerUser(UserDTO userDTO) {
        logger.info("Registering new user with username: {}", userDTO.getUsername());

        // Convert UserDTO to User entity
        User user = userMapper.toEntity(userDTO);

//        // Encode the password
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));


        // Encode the password only if it is provided
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }


        // Ensure the roles set is initialized
        Set<Role> roles = new HashSet<>();

        // Set default role to USER
        Role defaultRole = roleRepository.findByRoleName("USER")
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));
        roles.add(defaultRole);
        user.setRoles(roles);

        // Save the user to the database
        user = userRepository.save(user);
        logger.info("User registered successfully with ID: {}", user.getId());

        // Convert the saved user entity back to a UserDTO and return it
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        logger.info("Fetching user with ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        logger.info("Fetching user with username: {}", username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        logger.info("Fetching all users");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        logger.info("Updating user with ID: {}", id);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update user details
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        existingUser.setRoles(userMapper.mapRoleNameToRoles(userDTO.getRole()));

        existingUser = userRepository.save(existingUser);
        logger.info("User updated successfully with ID: {}", existingUser.getId());

        return userMapper.toDTO(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
        logger.info("User deleted successfully with ID: {}", id);
    }
}
