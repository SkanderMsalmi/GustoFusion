package com.gustofusion.gestionreservation.repositories;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.entites.RestaurantTable;

import com.gustofusion.gestionreservation.entites.TableStatus;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TableRepository extends JpaRepository<RestaurantTable,Integer> {
    List<RestaurantTable> findByStatus(TableStatus status);

    List<RestaurantTable> findByTableNumber(Integer tableNumber);

    List<RestaurantTable> findBySeatingCapacityGreaterThan(int seatingCapacity);

    List<RestaurantTable> findByLocationIgnoreCase(String location);

    List<RestaurantTable> findByStatusAndSeatingCapacityGreaterThan(TableStatus status, int seatingCapacity);

    // Sort
    List<RestaurantTable> findByStatusOrderBySeatingCapacityAsc(TableStatus status);

    List<RestaurantTable> findByStatusOrderByLocationDesc(TableStatus status);

    List<RestaurantTable> findByStatusOrderByStatusDescSeatingCapacityAsc(TableStatus status);


    // jointure

//    List<Reservation> findReservationsByRestaurantTable(RestaurantTable table);
}
