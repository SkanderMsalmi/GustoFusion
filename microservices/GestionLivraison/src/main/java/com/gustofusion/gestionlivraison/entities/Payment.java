package com.gustofusion.gestionlivraison.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Payment details
    private double amount; // Total payment amount
    private String paymentMethod; // Payment method used (e.g., credit card, cash, online payment)
    private String transactionId; // Unique transaction identifier
    private Date paymentDateTime; // Date and time of payment
    private String paymentStatus; // Payment status (e.g., paid, pending, failed)

    // Customer details
    private String customerName; // Name of the customer making the payment
    private String customerEmail; // Customer's email address
    private String customerPhone; // Customer's phone number

    // Order reference (if applicable)
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order; // The order to which this payment is associated

    // Getters and setters
}
