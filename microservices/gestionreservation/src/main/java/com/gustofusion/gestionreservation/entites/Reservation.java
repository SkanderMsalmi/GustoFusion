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
    private String email;
    private String phone;
    private String specialRequests;









    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;



}
