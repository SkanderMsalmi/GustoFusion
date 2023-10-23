package com.gustofusion.gestionemploye.controllers;

import com.gustofusion.gestionemploye.entities.Livreur;
import com.gustofusion.gestionemploye.services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/livreur")
public class LivreurController {
    @Autowired
    private LivreurService livreurService;
    @GetMapping("/{id}")
    public Livreur getLivreurById(@PathVariable Integer id) {return livreurService.getLivreurById(id);}
    @GetMapping()
    public ResponseEntity<List<Livreur>> retrieveAllLivreur(){
        List<Livreur> livreurs = livreurService.getLivreur();
        return  new ResponseEntity<>(livreurs, HttpStatus.OK);
    }
    @PostMapping()
    public Livreur createLivreur(@RequestBody Livreur livreur){ return livreurService.createLivreur(livreur);}
    @PutMapping("/{id}")
    public void updateLivreur(@PathVariable Integer id, @RequestBody Livreur livreur) {livreurService.updateLivreur(id,livreur);}

    @DeleteMapping("/{id}")
    public void deleteLivreur(@PathVariable Integer id) {
        livreurService.deleteLivreur(id);
    }
}

