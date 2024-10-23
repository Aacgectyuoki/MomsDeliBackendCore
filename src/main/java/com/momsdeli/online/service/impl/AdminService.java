package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.mapper.UserMapper;
import com.momsdeli.online.model.Address;
import com.momsdeli.online.model.Role;
import com.momsdeli.online.model.User;
import com.momsdeli.online.repository.RoleRepository;
import com.momsdeli.online.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AdminService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    /**
     * Method to programmatically create an admin user.
     *
     * @param username the username for the admin
     * @param email    the email for the admin
     * @param password the password for the admin
     * @return the created UserDTO
     */
    public UserDTO createAdminUser(String username, String email, String password) {
        log.info("Creating admin user with username: {}", username);

        // Check if the user already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User with username '" + username + "' already exists");
        }

        // Create a new User entity
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFirstName("Shahbaz");
        user.setLastName("Khan");
        user.setPhoneNumber("123-456-7890");

        // Create Address entities with proper details
        Address homeAddress = new Address();
        homeAddress.setAddressLine1("123 Shahbaz Lane");
        homeAddress.setAddressLine2("Apt 101");
        homeAddress.setCity("Karachi");
        homeAddress.setState("Sindh");
        homeAddress.setPostalCode("75500");
        homeAddress.setCountry("Pakistan");
        homeAddress.setUser(user);

        Address officeAddress = new Address();
        officeAddress.setAddressLine1("456 Office Blvd.");
        officeAddress.setAddressLine2("Suite 500");
        officeAddress.setCity("Islamabad");
        officeAddress.setState("Capital Territory");
        officeAddress.setPostalCode("44000");
        officeAddress.setCountry("Pakistan");
        officeAddress.setUser(user);

        // Add addresses to the user's addresses list
        user.setAddresses(Arrays.asList(homeAddress, officeAddress));

        // Assign the ADMIN role
        Role adminRole = roleRepository.findByRoleName("ADMIN")
                .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));
        user.setRoles(Set.of(adminRole));

        // Save the admin user to the database
        user = userRepository.save(user);
        log.info("Admin user created successfully with ID: {}", user.getId());

        // Convert the saved user entity back to a UserDTO and return it
        return userMapper.toDTO(user);
    }
}
