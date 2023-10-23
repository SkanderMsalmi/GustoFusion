package com.gustofusion.gestionreservation.services;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.entites.ReservationStatus;
import com.gustofusion.gestionreservation.entites.RestaurantTable;
import com.gustofusion.gestionreservation.repositories.ReservationRepository;
import com.gustofusion.gestionreservation.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private TableRepository restaurantTableRepository;
    @Autowired
    private  ReservationRepository reservationRepository;

    public ResponseEntity<String> addReservationToTable(Integer tableId, Reservation reservation) {
        RestaurantTable table = restaurantTableRepository.findById(tableId).orElse(null);

        if (table != null) {
            Date reservationStartDateTime = reservation.getReservationStartDateTime();
            Date reservationEndDateTime = reservation.getReservationEndDateTime();

            if (isTableAvailable(table,  reservationStartDateTime, reservationEndDateTime)) {
                reservation.setTable(table);
                reservation.setStatus(ReservationStatus.PENDING);
                Reservation addedReservation = reservationRepository.save(reservation);

                String message = "Reservation successfully added.";
                return new ResponseEntity<>(message, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("The table is already reserved during the requested time period.", HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity<>("Table with ID " + tableId + " not found.", HttpStatus.NOT_FOUND);
    }

    private boolean isTableAvailable(RestaurantTable table, Date reservationStartDateTime, Date reservationEndDateTime) {
        List<Reservation> existingReservations = reservationRepository.findByTable(table);
        for (Reservation existingReservation : existingReservations) {

            if (reservationStartDateTime.before(existingReservation.getReservationEndDateTime())
                    && reservationEndDateTime.after(existingReservation.getReservationStartDateTime())) {
                return false;
            }
        }

        return true;
    }
    public List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }
    public Reservation getReservationById(Integer id) {

        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation updateReservation(Integer id, Reservation updatedReservation) {
        // Implement your business logic for updating a reservation
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            updatedReservation.setId(existingReservation.getId());
            Reservation updated = reservationRepository.save(updatedReservation);

            return updated;
        }
        return null;
    }

    public boolean deleteReservation(Integer id) {
        // Implement your business logic for deleting a reservation
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            reservationRepository.delete(existingReservation);
            return true;
        }
        return false;
    }

    public Reservation updateReservationStatus(Integer id, ReservationStatus newStatus) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);

        if (existingReservation != null) {
            // Update the status of the existing reservation with the new status
            existingReservation.setStatus(newStatus);

            // Save the updated reservation in the database
            Reservation updated = reservationRepository.save(existingReservation);

            return updated;
        } else {
            // Return null if the reservation with the specified ID doesn't exist
            return null;
        }
    }



    public List<Reservation> getReservationsByCustomerName(String customerName) {
        return reservationRepository.findReservationsByCustomerNameContaining(customerName);
    }


}
