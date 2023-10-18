package com.gustofusion.gestionreservation.controller;

import com.gustofusion.gestionreservation.entites.Reservation;
import com.gustofusion.gestionreservation.entites.RestaurantTable;
import com.gustofusion.gestionreservation.entites.RestaurantTable;
import com.gustofusion.gestionreservation.entites.TableStatus;
import com.gustofusion.gestionreservation.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController()
@RequestMapping(value = "/tables")
public class TableController {
    @Autowired
    private TableService tableService;

    @PostMapping
    public RestaurantTable createTable(@RequestBody RestaurantTable  table) {
        return tableService.createTable(table);
    }

    @GetMapping("/{id}")
    public RestaurantTable  getTableById(@PathVariable Integer id) {
        return tableService.getTableById(id);
    }

    @PutMapping("/{id}")
    public void updateTable(@PathVariable Integer id, @RequestBody RestaurantTable updatedTable) {
        tableService.updateTable(id, updatedTable);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Integer id) {
        tableService.deleteTable(id);
    }

    // List all tables
    @GetMapping
    public List<RestaurantTable> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/status/{status}")
    public List<RestaurantTable> getTablesByStatus(@PathVariable TableStatus status) {
        return tableService.getTablesByStatus(status);
    }

    @GetMapping("/seating-capacity-greater-than/{seatingCapacity}")
    public List<RestaurantTable> getTablesBySeatingCapacityGreaterThan(@PathVariable int seatingCapacity) {
        return tableService.getTablesBySeatingCapacityGreaterThan(seatingCapacity);
    }

    @GetMapping("/location/{location}")
    public List<RestaurantTable> getTablesByLocationIgnoreCase(@PathVariable String location) {
        return tableService.getTablesByLocationIgnoreCase(location);
    }

    @GetMapping("/status-and-seating-capacity/{status}/{seatingCapacity}")
    public List<RestaurantTable> getTablesByStatusAndSeatingCapacity(@PathVariable TableStatus status, @PathVariable int seatingCapacity) {
        return tableService.getTablesByStatusAndSeatingCapacity(status, seatingCapacity);
    }

    @GetMapping("/status/{status}/sorted-by-seating-capacity")
    public List<RestaurantTable> getTablesByStatusAndSortBySeatingCapacityAsc(@PathVariable TableStatus status) {
        return tableService.getTablesByStatusAndSortBySeatingCapacityAsc(status);
    }

    @GetMapping("/status/{status}/sorted-by-location-desc")
    public List<RestaurantTable> getTablesByStatusAndSortByLocationDesc(@PathVariable TableStatus status) {
        return tableService.getTablesByStatusAndSortByLocationDesc(status);
    }

    @GetMapping("/status/{status}/sorted-by-status-desc-seating-capacity-asc")
    public List<RestaurantTable> getTablesByStatusAndSortByStatusDescAndSeatingCapacityAsc(@PathVariable TableStatus status) {
        return tableService.getTablesByStatusAndSortByStatusDescAndSeatingCapacityAsc(status);
    }

    @GetMapping("/{tableId}/reservations")
    public List<Reservation> getReservationsForTable(@PathVariable Integer tableId) {
        return tableService.getReservationsForTable(tableId);
    }

}
