package com.momsdeli.online.model;

import com.momsdeli.online.model.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "discounts")
public class Discount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double discountValue; // Percentage or flat value

    @Column(nullable = false)
    private boolean isPercentage; // True if percentage discount, false if flat discount

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
