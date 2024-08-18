package com.momsdeli.online.repository;

import com.momsdeli.online.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
    // You can add custom queries here if needed
}
