package com.momsdeli.online.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public void addItem(CartItem cartItem) {
        // Set the cart in CartItem to ensure the bidirectional relationship is maintained
        cartItem.setCart(this);
        // Add the CartItem to the list of cart items
        this.cartItems.add(cartItem);
    }
}
