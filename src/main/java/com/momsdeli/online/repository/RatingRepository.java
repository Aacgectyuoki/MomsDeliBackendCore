package com.momsdeli.online.repository;

import com.momsdeli.online.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    // You can add custom queries here if needed
}
