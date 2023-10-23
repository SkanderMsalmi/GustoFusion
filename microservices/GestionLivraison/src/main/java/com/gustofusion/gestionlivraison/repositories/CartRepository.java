package com.gustofusion.gestionlivraison.repositories;

import com.gustofusion.gestionlivraison.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
