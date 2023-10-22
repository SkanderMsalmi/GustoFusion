package com.gustofusion.gestionmenu.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode

public class MenuItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    @JsonIgnoreProperties("menuItems")
    @ManyToOne(cascade = CascadeType.ALL)
    Category category;

    @JsonIgnoreProperties("menuItems")
    @ManyToMany(mappedBy = "menuItems",cascade = CascadeType.ALL)
    private List<Menu> menus;
}
