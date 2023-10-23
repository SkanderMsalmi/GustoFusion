package com.gustofusion.gestionlivraison.repositories;

import com.gustofusion.gestionlivraison.entities.Delivery;
import com.gustofusion.gestionlivraison.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
