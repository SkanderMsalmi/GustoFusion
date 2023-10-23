package com.gustofusion.gestionlivraison.repositories;

import com.gustofusion.gestionlivraison.entities.Delivery;
import com.gustofusion.gestionlivraison.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
