package com.momsdeli.online.model;

import com.momsdeli.online.model.BaseEntity;
import com.momsdeli.online.model.Cart;
import com.momsdeli.online.model.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
