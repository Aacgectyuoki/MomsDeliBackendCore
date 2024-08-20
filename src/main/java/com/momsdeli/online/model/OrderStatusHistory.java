package com.momsdeli.online.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "order_status_history")
public class OrderStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;

    @Column(nullable = false, length = 50)
    private String status; // e.g., PENDING, SHIPPED, DELIVERED

    @Column(nullable = false)
    private LocalDateTime changedAt = LocalDateTime.now();
}
