package com.gustofusion.gestionreservation.services;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.entites.ReservationStatus;
import com.gustofusion.gestionreservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private  ReservationRepository reservationRepository;
    public Reservation createReservation(Reservation reservation) {
        // Implement your business logic for creating a reservation
        // You can add validation, calculations, or other operations here
        return reservationRepository.save(reservation);
    }
    public List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }
    public Reservation getReservationById(Integer id) {
        // Implement your business logic for retrieving a reservation by ID
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
    public List<Reservation> getReservationsByTableNumber(int tableNumber) {
        return reservationRepository.findByTableNumber(tableNumber);
    }
    public List<Reservation> getReservationsByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return reservationRepository.findByReservationDateTimeBetween(startTime, endTime);
    }

    public List<Reservation> getReservationsByCustomerName(String customerName) {
        return reservationRepository.findReservationsByCustomerNameContaining(customerName);
    }
}
