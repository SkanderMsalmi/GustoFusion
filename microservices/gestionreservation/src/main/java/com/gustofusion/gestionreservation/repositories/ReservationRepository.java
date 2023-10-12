package com.gustofusion.gestionreservation.repositories;

import com.gustofusion.gestionreservation.entites.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

}
