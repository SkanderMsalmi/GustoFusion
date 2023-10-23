package com.gustofusion.gestionlivraison.controllers;

import com.gustofusion.gestionlivraison.entities.Order;
import com.gustofusion.gestionlivraison.entities.OrderItem;
import com.gustofusion.gestionlivraison.services.CartService;
import com.gustofusion.gestionlivraison.services.OrderItemService;
import com.gustofusion.gestionlivraison.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8088"})
@RequestMapping("/orders")

public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order,@RequestParam Long cartId) {
        Order addedOrder = orderService.addOrder(order,cartId);
        orderService.assignOrderToDriver();
        System.out.println("order succeed");
       return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
        //return ResponseEntity.ok();
    }

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestParam Long cartId) {
        Order order = cartService.placeOrder(cartId);
        return ResponseEntity.ok(order);
    }
}
