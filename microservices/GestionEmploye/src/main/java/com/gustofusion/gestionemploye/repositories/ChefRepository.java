package com.gustofusion.gestionemploye.repositories;

import com.gustofusion.gestionemploye.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef,Integer> {

}
