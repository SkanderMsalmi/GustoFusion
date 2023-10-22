package com.gustofusion.gestionemploye.services;

import com.gustofusion.gestionemploye.entities.Chef;
import com.gustofusion.gestionemploye.repositories.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;
    public List<Chef> getChef(){
        return chefRepository.findAll();
    }
    public Chef getChefById(Integer id) {
        return chefRepository.findById(id).orElse(null);
    }

    public Chef createChef(Chef chef){
        return chefRepository.save(chef);
    }
    public void updateChef(Integer id, Chef updatedChef) {

        Chef existingChef = chefRepository.findById(id).orElse(null);

        if (existingChef != null) {
            existingChef.setNom(updatedChef.getNom());
            existingChef.setBadge(updatedChef.getBadge());
            existingChef.setPrenom(updatedChef.getPrenom());
            existingChef.setSalaire(updatedChef.getSalaire());
            existingChef.setSpecialite(updatedChef.getSpecialite());
            chefRepository.save(existingChef);
        }
    }
    public void deleteChef(Integer id) {
        chefRepository.deleteById(id);
    }



}
