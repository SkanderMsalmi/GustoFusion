package com.gustofusion.gestionlivraison.repositories;

import com.gustofusion.gestionemploye.entities.Livreur;
import com.gustofusion.gestionlivraison.entities.Delivery;
import com.gustofusion.gestionlivraison.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

    //Delivery findByOrderAndDriver(Order order, Livreur driver);
    Delivery findByOrderIdAndDriver(Long orderId,Livreur driver);
}
