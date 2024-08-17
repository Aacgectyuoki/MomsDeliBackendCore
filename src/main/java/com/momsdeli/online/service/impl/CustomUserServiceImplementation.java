/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:39 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.mapper.UserMapper;
import com.momsdeli.online.repository.UserRepository;
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

    public CustomUserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.momsdeli.online.model.User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email -" + username);
        }

        // Convert User entity to UserDTO
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);

        // Construct UserDetails object using UserDTO
        List<GrantedAuthority> authorityList = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(
                userDTO.getEmail(),
                userDTO.getPassword(),
                authorityList
        );
    }
}
