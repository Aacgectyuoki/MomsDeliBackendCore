package com.momsdeli.online.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;

    @Column(nullable = false, length = 50)
    private String paymentMethod;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 50)
    private String paymentStatus;

    @Column(nullable = false, unique = true, length = 100)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
