package com.gustofusion.gestionreservation.controller;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.entites.ReservationStatus;
import com.gustofusion.gestionreservation.services.ReservationService;
import com.gustofusion.gestionreservation.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController()
@RequestMapping(value = "/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private TableService tableService;

    @GetMapping()
    public ResponseEntity<List<Reservation>> retrieveAllReservation(){
        List<Reservation> reservations = reservationService.getReservation();
        return new ResponseEntity<>(reservations,HttpStatus.OK);
    }


    @PostMapping("/{tableId}/reservations")
    public ResponseEntity<String> addReservationToTable(@PathVariable Integer tableId, @RequestBody Reservation reservation) {
        ResponseEntity<String> response = reservationService.addReservationToTable(tableId, reservation);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    // Retrieve a reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Integer id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a reservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Integer id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservation);
        if (updatedReservation != null) {
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Integer id) {
        if (reservationService.deleteReservation(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Reservation> setReservationStatus(
            @PathVariable Integer id,
            @RequestParam ReservationStatus status
    ) {
        Reservation updatedReservation = reservationService.updateReservationStatus(id, status);

        if (updatedReservation != null) {
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // Retrieve reservations within a time range
    @GetMapping("/byTimeRange")
    public ResponseEntity<List<Reservation>> getReservationsByTimeRange(
            @RequestBody Date startTime
          ) {
//        List<Reservation> reservations = reservationService.getReservationsByTimeRange(startTime, endTime);

//        if (!reservations.isEmpty()) {
//            return new ResponseEntity<>(reservations, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        System.out.println(startTime);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/byCustomerName/{customerName}")
    public ResponseEntity<List<Reservation>> getReservationsByCustomerName(
            @RequestParam String customerName) {
        List<Reservation> reservations = reservationService.getReservationsByCustomerName(customerName);

        if (!reservations.isEmpty()) {
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
