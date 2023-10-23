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
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MenuItem menuItem;
    private int quantity;
    @ManyToOne
    private Cart cart;
}
