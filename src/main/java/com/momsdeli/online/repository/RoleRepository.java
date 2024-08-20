package com.momsdeli.online.repository;

import com.momsdeli.online.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM roles WHERE role_name = :roleName", nativeQuery = true)
    Optional<Role> findByRoleName(@Param("roleName") String roleName);
}