/**
 * Author: Shahbaz Ali
 * Email: shahbazkhaniq@gmail.com
 * Date: 2/27/2024$
 * Time: 11:27 PM$
 * Project Name: MomsDeliBackendCore$
 */


package com.momsdeli.online.repository;

import com.momsdeli.online.dto.UserDTO;
import com.momsdeli.online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    User findByEmail(String email);
    User findByEmail(String email);
}
