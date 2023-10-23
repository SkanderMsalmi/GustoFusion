package com.gustofusion.gestionlivraison.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustofusion.gestionemploye.entities.Livreur;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
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
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other attributes for the delivery (e.g., status, location, timestamps).

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Livreur driver;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Pending'")
    private String deliveryStatus;
    private int customerRating; // A scale (e.g., 1-5) for rating
    private String customerFeedback;
    private String deliveryConfirmationCode;
    private double deliveryFee;
    private Date estimatedDeliveryTime;
    private Date actualDeliveryTime;

    private Long orderId;
    @OneToMany(mappedBy = "delivery",cascade = CascadeType.ALL)
    private List<Order> orders;

}
