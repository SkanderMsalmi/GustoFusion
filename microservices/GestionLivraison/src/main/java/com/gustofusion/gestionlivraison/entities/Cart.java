package com.gustofusion.gestionlivraison.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartItem> cartItems;
    @JsonIgnore
    @OneToOne(mappedBy = "cart")
    private Order order; // Reference to the order
    public void clearCart() {
        this.cartItems.clear();
    }
    // Other cart-related attributes
    // Getters and setters
}
