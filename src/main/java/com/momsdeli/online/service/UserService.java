package com.momsdeli.online.service;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.exceptions.UserException;

public interface UserService {


    UserDTO getUserDtoById(Long id);

    UserDTO findUserById(Long UserId) throws UserException;

    UserDTO findUserProfileByJwt(String jwt) throws UserException;


}
