package com.gustofusion.gestionreservation.services;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.entites.RestaurantTable;

import com.gustofusion.gestionreservation.entites.TableStatus;
import com.gustofusion.gestionreservation.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public RestaurantTable createTable(RestaurantTable table) {
        table.setStatus(TableStatus.AVAILABLE);
        return tableRepository.save(table);
    }

    public List<RestaurantTable> getAllTables() {
        return tableRepository.findAll();
    }

    public RestaurantTable getTableById(Integer id) {
        return tableRepository.findById(id).orElse(null);
    }

    public void updateTable(Integer id, RestaurantTable updatedTable) {

        RestaurantTable existingTable = tableRepository.findById(id).orElse(null);

        if (existingTable != null) {
            existingTable.setTableNumber(updatedTable.getTableNumber());
            existingTable.setSeatingCapacity(updatedTable.getSeatingCapacity());
            existingTable.setLocation(updatedTable.getLocation());
            existingTable.setStatus(updatedTable.getStatus());
            existingTable.setSeatingCapacity(updatedTable.getSeatingCapacity());
            tableRepository.save(existingTable);
        }
    }

    public void deleteTable(Integer id) {
        tableRepository.deleteById(id);
    }

    public List<RestaurantTable> getTablesByStatus(TableStatus status) {
        return tableRepository.findByStatus(status);
    }

    public List<RestaurantTable> getTablesBySeatingCapacityGreaterThan(int seatingCapacity) {
        return tableRepository.findBySeatingCapacityGreaterThan(seatingCapacity);
    }

    public List<RestaurantTable> getTablesByLocationIgnoreCase(String location) {
        return tableRepository.findByLocationIgnoreCase(location);
    }

    public List<RestaurantTable> getTablesByStatusAndSeatingCapacity(TableStatus status, int seatingCapacity) {
        return tableRepository.findByStatusAndSeatingCapacityGreaterThan(status, seatingCapacity);
    }

    public List<RestaurantTable> getTablesByStatusAndSortBySeatingCapacityAsc(TableStatus status) {
        return tableRepository.findByStatusOrderBySeatingCapacityAsc(status);
    }

    public List<RestaurantTable> getTablesByStatusAndSortByLocationDesc(TableStatus status) {
        return tableRepository.findByStatusOrderByLocationDesc(status);
    }

    public List<RestaurantTable> getTablesByStatusAndSortByStatusDescAndSeatingCapacityAsc(TableStatus status) {
        return tableRepository.findByStatusOrderByStatusDescSeatingCapacityAsc(status);
    }

    // jointure

    public List<Reservation> getReservationsForTable(Integer tableId) {
        RestaurantTable table = tableRepository.findById(tableId).orElse(null);
        if (table != null) {
            return table.getReservations();
        }
        return Collections.emptyList();
    }
}
