package com.momsdeli.online.repository;

import com.momsdeli.online.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom queries here if needed
}
