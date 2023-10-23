package com.gustofusion.gestionlivraison.services;

import com.gustofusion.gestionlivraison.entities.Order;

public interface OrderServiceInterface {
    Order addOrder(Order order,Long cartId);
}
