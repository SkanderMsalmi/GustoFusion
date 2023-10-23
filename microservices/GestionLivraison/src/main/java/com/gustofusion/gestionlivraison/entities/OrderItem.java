package com.gustofusion.gestionlivraison.entities;
import com.gustofusion.gestionmenu.entities.MenuItem;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order; // The owning order
    // Other order item attributes (e.g., notes, special requests)

    // Getters and setters
}
