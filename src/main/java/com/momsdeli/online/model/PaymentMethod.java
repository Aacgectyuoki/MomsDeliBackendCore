package com.momsdeli.online.model;

/**
 * @author Shahbaz Khan
 * @date 19/08/2024
 */

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 50)
    private String methodType; // e.g., Credit Card, PayPal

    @Column(nullable = false, length = 100)
    private String provider; // e.g., Visa, MasterCard

    @Column(nullable = false, length = 100)
    private String accountNumber;

    @Column(nullable = true)
    private String expiryDate;
}
