package com.gustofusion.gestionreservation.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "RestaurantTable")
@Data
public class RestaurantTable  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seatingCapacity;
    private Integer tableNumber;
    private String location;
    @Enumerated(EnumType.STRING)
    private TableStatus status;
    @JsonIgnore
    @OneToMany(mappedBy = "table")
    private List<Reservation> reservations;
}
