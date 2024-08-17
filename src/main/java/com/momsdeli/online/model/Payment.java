package com.momsdeli.online.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
