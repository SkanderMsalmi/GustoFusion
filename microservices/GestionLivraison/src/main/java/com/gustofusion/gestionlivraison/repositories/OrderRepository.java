package com.gustofusion.gestionlivraison.repositories;

import com.gustofusion.gestionlivraison.entities.Delivery;
import com.gustofusion.gestionlivraison.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
