package com.gustofusion.gestionlivraison.controllers;

import com.gustofusion.gestionlivraison.entities.Delivery;
import com.gustofusion.gestionlivraison.services.DeliveryService;
import com.gustofusion.gestionlivraison.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @PostMapping
    public ResponseEntity<Delivery> createDelivery(
            @RequestParam("orderId") Long orderId,
            @RequestParam("driverId") int driverId,
            @RequestBody Delivery delivery) {
        // Call your DeliveryService to create the delivery with the orderId and driverId
        Delivery createdDelivery = deliveryService.createDelivery(orderId, driverId, delivery);
        deliveryService.sendConfirmationCode(orderId,createdDelivery.getDeliveryConfirmationCode());
        return new ResponseEntity<>(createdDelivery, HttpStatus.CREATED);
    }

    @PostMapping("/ConfirmDelivery")
    public ResponseEntity<String> ConfirmDelivery(
            @RequestParam("orderId") Long orderId,
            @RequestParam("providedConfirmationCode") String providedConfirmationCode) {
        try {
            deliveryService.confirmDelivery(orderId, providedConfirmationCode);
            return ResponseEntity.ok("Delivery confirmed successfully.");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delivery not found.");
        } catch (IllegalArgumentException  ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid confirmation code.");
        }
    }

    @PutMapping("/customerFeedBack")
    public ResponseEntity<String> updateDelivery(
            @RequestParam Long orderId,
            @RequestParam int driverId,
            @RequestParam String customerFeedback,
            @RequestParam int customerRating,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date actualDeliveryTime) {

        deliveryService.updateDelivery(orderId, driverId, customerFeedback, customerRating, actualDeliveryTime);

        return ResponseEntity.ok("Delivery updated successfully");
    }







}

