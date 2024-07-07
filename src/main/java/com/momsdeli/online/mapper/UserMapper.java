package com.momsdeli.online.mapper;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        userDTO.setMobilePhone(user.getMobilePhone());
        userDTO.setAddressList(user.getAddressList().stream()
                .map(AddressMapper::toDTO) // Assuming AddressMapper is implemented similarly
                .collect(Collectors.toList()));
        userDTO.setPaymentInformations(user.getPaymentInformations().stream()
                .map(PaymentInformationMapper::toDTO) // Assuming PaymentInformationMapper is implemented similarly
                .collect(Collectors.toList()));
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setMobilePhone(userDTO.getMobilePhone());
        user.setAddressList(userDTO.getAddressList().stream()
                .map(AddressMapper::toEntity) // Assuming AddressMapper is implemented similarly
                .collect(Collectors.toList()));
        user.setPaymentInformations(userDTO.getPaymentInformations().stream()
                .map(PaymentInformationMapper::toEntity) // Assuming PaymentInformationMapper is implemented similarly
                .collect(Collectors.toSet())); // Changed from toList() to toSet()
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
}
