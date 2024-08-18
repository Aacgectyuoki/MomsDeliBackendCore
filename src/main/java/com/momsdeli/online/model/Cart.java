package com.momsdeli.online.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @Setter
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public void addItem(CartItem item) {
        cartItems.add(item);
        // Do not set the cart reference in CartItem
    }

    public void removeItem(CartItem item) {
        cartItems.remove(item);
        // Do not unset the cart reference in CartItem
    }

}
