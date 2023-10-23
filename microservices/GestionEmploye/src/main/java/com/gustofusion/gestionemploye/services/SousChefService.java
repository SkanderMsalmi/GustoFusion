package com.gustofusion.gestionemploye.services;

import com.gustofusion.gestionemploye.entities.SousChef;
import com.gustofusion.gestionemploye.repositories.ChefRepository;
import com.gustofusion.gestionemploye.repositories.SousChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousChefService {
        @Autowired
        private SousChefRepository sousChefRepository;


        public List<SousChef> getSousChefs(){
            return sousChefRepository.findAll();
        }

        public SousChef getSousChefById(Integer id) {
            return sousChefRepository.findById(id).orElse(null);
        }

        public SousChef createSousChef(SousChef sousChef){
            return sousChefRepository.save(sousChef);
        }

        public void updateSousChef(Integer id, SousChef updatedSousChef) {
            SousChef existingSousChef = sousChefRepository.findById(id).orElse(null);

            if (existingSousChef != null) {
                existingSousChef.setNom(updatedSousChef.getNom());
                existingSousChef.setBadge(updatedSousChef.getBadge());
                existingSousChef.setPrenom(updatedSousChef.getPrenom());
                existingSousChef.setSalaire(updatedSousChef.getSalaire());
                existingSousChef.setTypeService(updatedSousChef.getTypeService());
                existingSousChef.setChef(updatedSousChef.getChef());
                sousChefRepository.save(existingSousChef);
            }
        }

        public void deleteSousChef(Integer id) {
            sousChefRepository.deleteById(id);
        }

}
