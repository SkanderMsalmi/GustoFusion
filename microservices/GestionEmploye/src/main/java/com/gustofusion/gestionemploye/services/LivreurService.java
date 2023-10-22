package com.gustofusion.gestionemploye.services;

import com.gustofusion.gestionemploye.entities.Livreur;
import com.gustofusion.gestionemploye.repositories.LivreurRepository;
import com.gustofusion.gestionemploye.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurService {
    @Autowired
    private LivreurRepository livreurRepository;

    public List<Livreur> getLivreur() {return livreurRepository.findAll();}
    public Livreur getLivreurById(Integer id) {return livreurRepository.findById(id).orElse(null);}
    
    public Livreur createLivreur(Livreur livreur){return livreurRepository.save(livreur);}
    
    public void updateLivreur(Integer id, Livreur updatedLivreur){
        Livreur existingLivreur = livreurRepository.findById(id).orElse(null);
        
        if (existingLivreur != null) {
            existingLivreur.setNom(updatedLivreur.getNom());
            existingLivreur.setBadge(updatedLivreur.getBadge());
            existingLivreur.setPrenom(updatedLivreur.getPrenom());
            existingLivreur.setSalaire(updatedLivreur.getSalaire());
            existingLivreur.setDisponiblite(updatedLivreur.isDisponiblite());
            existingLivreur.setNumTel(updatedLivreur.getNumTel());
            livreurRepository.save(existingLivreur);
        }
    }
    public void deleteLivreur(Integer id) {livreurRepository.deleteById(id);}
}
