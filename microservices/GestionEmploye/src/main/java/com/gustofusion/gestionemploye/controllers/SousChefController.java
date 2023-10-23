package com.gustofusion.gestionemploye.controllers;

import com.gustofusion.gestionemploye.entities.SousChef;
import com.gustofusion.gestionemploye.services.SousChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/sous-chef")
public class SousChefController {
    @Autowired
    private SousChefService sousChefService;

    @GetMapping("/{id}")
    public SousChef getSousChefById(@PathVariable Integer id) {
        return sousChefService.getSousChefById(id);
    }

    @GetMapping()
    public ResponseEntity<List<SousChef>> retrieveAllSousChefs(){
        List<SousChef> sousChefs = sousChefService.getSousChefs();
        return new ResponseEntity<>(sousChefs, HttpStatus.OK);
    }

    @PostMapping()
    public SousChef createSousChef(@RequestBody SousChef sousChef){
        return sousChefService.createSousChef(sousChef);
    }

    @PutMapping("/{id}")
    public void updateSousChef(@PathVariable Integer id, @RequestBody SousChef sousChef) {
        sousChefService.updateSousChef(id, sousChef);
    }

    @DeleteMapping("/{id}")
    public void deleteSousChef(@PathVariable Integer id) {
        sousChefService.deleteSousChef(id);
    }
}