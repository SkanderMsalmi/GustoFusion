package com.gustofusion.gestionreservation.repositories;

import com.gustofusion.gestionreservation.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByTableNumber(int tableNumber);
    List<Reservation> findByReservationDateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT r FROM Reservation r WHERE r.customerName LIKE %:name%")
    List<Reservation> findReservationsByCustomerNameContaining(@Param("name") String name);
}
