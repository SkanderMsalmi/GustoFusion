package com.gustofusion.gestionemploye.repositories;

import com.gustofusion.gestionemploye.entities.SousChef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousChefRepository extends JpaRepository<SousChef,Integer> {

}
