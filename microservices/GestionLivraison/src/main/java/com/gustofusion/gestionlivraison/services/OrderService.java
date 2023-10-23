package com.gustofusion.gestionlivraison.services;

import com.gustofusion.gestionemploye.entities.Livreur;
import com.gustofusion.gestionemploye.repositories.LivreurRepository;
import com.gustofusion.gestionlivraison.entities.Cart;
import com.gustofusion.gestionlivraison.entities.CartItem;
import com.gustofusion.gestionlivraison.entities.Order;
import com.gustofusion.gestionlivraison.entities.OrderItem;
import com.gustofusion.gestionlivraison.repositories.CartRepository;
import com.gustofusion.gestionlivraison.repositories.OrderRepository;
import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceInterface {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private LivreurRepository livreurRepository;

    private Order actualOrder;

    public Order addOrder(Order order,Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null || cart.getCartItems().isEmpty()) {
            throw new IllegalArgumentException("The cart is empty.");
        }

      /*  List<Livreur> livreurs = livreurRepository.findAll();
        for(Livreur livreur :livreurs){
            if (livreur.isDisponiblite()) {
               // Twilio.init(System.getenv("ACf6ca18796a5cf6359536ab7a55a516ac"), System.getenv("1708fcc0add1c2d5866bbe99655a355e"));
                String LivTel =Integer.toString(livreur.getNumTel());
                String smsBody = "Hello sir, you have new order with the ID:"+order.getId()+" the following details:\n"
                        +"Delivery state :"+ order.getDeliveryState()+"\n"
                        +"Delivery code postal:"+order.getDeliveryPostalCode()+"\n"
                        +"Delivery street address:"+order.getDeliveryStreetAddress();
                Twilio.init("ACf6ca18796a5cf6359536ab7a55a516ac", "1708fcc0add1c2d5866bbe99655a355e");
                Message.creator(new PhoneNumber("+216"+LivTel),
                        new PhoneNumber("+19519164849"), smsBody).create();
            }
                break;
        }*/
        // Create an order and add order items

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
         orderRepository.save(order);
        cart.setOrder(order);
        cart.clearCart();
        cartRepository.save(cart);
        actualOrder=order;
        return order;

    }

    public void assignOrderToDriver(){
        List<Livreur> livreurs = livreurRepository.findAll();
        for(Livreur livreur :livreurs){
            if (livreur.isDisponiblite()) {
                // Twilio.init(System.getenv("ACf6ca18796a5cf6359536ab7a55a516ac"), System.getenv("1708fcc0add1c2d5866bbe99655a355e"));
                String LivTel =Integer.toString(livreur.getNumTel());
                String smsBody = "Hello sir, you have new order with the ID:"+actualOrder.getId()+" the following details:\n"
                        +"Delivery state :"+ actualOrder.getDeliveryState()+"\n"
                        +"Delivery code postal:"+actualOrder.getDeliveryPostalCode()+"\n"
                        +"Delivery street address:"+actualOrder.getDeliveryStreetAddress();
                Twilio.init("ACbe95647bac01abcb809623c19bdd3d9f", "11ece026195b73cfd43730f5d72bd4d8");
                Message.creator(new PhoneNumber("+216"+LivTel),
                        new PhoneNumber("+18456320970"), smsBody).create();
            }
            break;
        }
    }


}
