package com.gustofusion.gestionemploye.repositories;

import com.gustofusion.gestionemploye.entities.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreurRepository extends JpaRepository<Livreur,Integer> {

}
