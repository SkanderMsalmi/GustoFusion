package com.gustofusion.gestionlivraison.controllers;

import com.gustofusion.gestionlivraison.entities.Cart;
import com.gustofusion.gestionlivraison.entities.CartItem;
import com.gustofusion.gestionlivraison.repositories.CartRepository;
import com.gustofusion.gestionlivraison.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8088"})

@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/create")
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam("cartId") Long cartId, @RequestParam("menuItemId") Long menuItemId, @RequestParam("quantity") int quantity) {
        Cart cart = cartService.addToCart(cartRepository.findById(cartId).orElse(null), menuItemId, quantity);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeFromCart(@RequestParam Long cartId, @RequestParam Long cartItemId) {
        cartService.removeFromCart(cartRepository.findById(cartId).orElse(null), cartItemId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/clear")
    public ResponseEntity<Void> clearCart(@RequestParam Long cartId) {
        cartService.clearCart(cartRepository.findById(cartId).orElse(null));
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/cartItems")
    public ResponseEntity<List<CartItem>> retrieveAllCartItems(){
        List<CartItem> cartItemList = cartService.getCartItem();
        return new ResponseEntity<>(cartItemList, HttpStatus.OK);
    }

}
