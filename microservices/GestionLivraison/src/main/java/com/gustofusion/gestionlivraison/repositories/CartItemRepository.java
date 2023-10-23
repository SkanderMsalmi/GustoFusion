package com.gustofusion.gestionlivraison.repositories;


import com.gustofusion.gestionlivraison.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
