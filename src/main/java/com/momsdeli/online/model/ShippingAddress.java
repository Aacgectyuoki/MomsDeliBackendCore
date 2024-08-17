package com.momsdeli.online.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String country;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
