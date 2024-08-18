package com.momsdeli.online.repository;

import com.momsdeli.online.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // You can add custom queries here if needed
}
