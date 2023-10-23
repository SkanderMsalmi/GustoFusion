package com.gustofusion.gestionlivraison.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToOne
    private Cart cart;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems= new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDateTime;
    private String orderStatus;
    private String customerEmail;
    private String customerPhone;
    private String deliveryStreetAddress;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryPostalCode;
    private String deliveryInstructions;
    private double orderTotalAmount;
    private String paymentStatus;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'cash'")
    private String paymentMethod;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
