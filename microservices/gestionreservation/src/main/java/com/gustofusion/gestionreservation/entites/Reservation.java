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
    private String specialRequests;

    @Column(name = "table_number")
    @Min(value = 1, message = "Table number must be at least 1")
    @Max(value = 100, message = "Table number cannot exceed 100")
    private Integer tableNumber;
    @Column(nullable = true)
    private double totalPrice;



    private String confirmationCode;
    @Column(nullable = true)
    private String cancellationPolicy;




}
