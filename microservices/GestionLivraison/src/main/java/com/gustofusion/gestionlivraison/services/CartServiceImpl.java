package com.gustofusion.gestionlivraison.services;

import com.gustofusion.gestionlivraison.entities.Cart;
import com.gustofusion.gestionlivraison.entities.CartItem;
import com.gustofusion.gestionlivraison.entities.Order;
import com.gustofusion.gestionlivraison.entities.OrderItem;
import com.gustofusion.gestionlivraison.repositories.CartItemRepository;
import com.gustofusion.gestionlivraison.repositories.CartRepository;
import com.gustofusion.gestionlivraison.repositories.OrderRepository;
import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;// You should create this repository
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<CartItem> getCartItem(){
        return cartItemRepository.findAll();
    }
    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    @Override
    public Cart addToCart(Cart cart, Long menuItemId, int quantity) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new EntityNotFoundException("Menu Item not found"));

        CartItem cartItem = new CartItem();
        cartItem.setMenuItem(menuItem);
        cartItem.setQuantity(quantity);
        cartItem.setCart(cart);

        if (cart.getCartItems() == null) {
            cart.setCartItems(new ArrayList<>());
        }
        cart.getCartItems().add(cartItem);

        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Cart cart, Long cartItemId) {
        cart.getCartItems().removeIf(item -> item.getId().equals(cartItemId));
        cartRepository.save(cart);
    }

    @Override
    public void clearCart(Cart cart) {
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }
    @Override
    public Order placeOrder(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null || cart.getCartItems().isEmpty()) {
            throw new IllegalArgumentException("The cart is empty.");
        }

        // Create an order and add order items
        Order order = new Order();
        List<CartItem> cartItems = cart.getCartItems();
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(cartItem.getMenuItem());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);

        // Save the order and clear the cart
       // orderRepository.save(order);
        cart.setOrder(order);
        clearCart(cart);
        cartRepository.save(cart);

        return order;
    }
}
