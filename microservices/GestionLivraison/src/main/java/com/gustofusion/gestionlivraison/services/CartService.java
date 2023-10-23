package com.gustofusion.gestionlivraison.services;

import com.gustofusion.gestionlivraison.entities.Cart;
import com.gustofusion.gestionlivraison.entities.CartItem;
import com.gustofusion.gestionlivraison.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
    Cart createCart();
    Cart addToCart(Cart cart, Long menuItemId, int quantity);
    void removeFromCart(Cart cart, Long cartItemId);
    void clearCart(Cart cart);
    Order placeOrder(Long cartId);
    List<CartItem> getCartItem();
}
