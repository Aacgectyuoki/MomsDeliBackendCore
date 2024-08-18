package com.momsdeli.online.repository;

import com.momsdeli.online.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    // You can add custom queries here if needed
}
