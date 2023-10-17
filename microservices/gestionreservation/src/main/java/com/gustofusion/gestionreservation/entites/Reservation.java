package com.gustofusion.gestionreservation.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne
//    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationStartDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationEndDateTime;

//    @ManyToOne
//    private TableOrVenue tableOrVenue;
    @Enumerated(EnumType.STRING)
    private ReservationStatus  status;

    @Column(nullable = true)
    private String customerName;
    @Column(nullable = true)
    private String contactInformation;
    private String specialRequests;



    @Column(nullable = true)
    private double totalPrice;



    private String confirmationCode;
    @Column(nullable = true)
    private String cancellationPolicy;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;



}
