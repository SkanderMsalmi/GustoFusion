package com.gustofusion.gestionreservation.controller;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping()
    public String getHello(){
        return "hello";
    }


}
