package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.mapper.UserMapper;
import com.momsdeli.online.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public CustomUserServiceImplementation(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.momsdeli.online.model.User user = userRepository.findByEmail(username);

        if (user == null || StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("User not found with email - " + username);
        }

        // Convert User entity to UserDTO
        UserDTO userDTO = userMapper.toDTO(user);

        // Construct UserDetails object using UserDTO
        List<GrantedAuthority> authorityList = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(
                userDTO.getEmail(),
                userDTO.getPassword(),
                authorityList
        );
    }
}
