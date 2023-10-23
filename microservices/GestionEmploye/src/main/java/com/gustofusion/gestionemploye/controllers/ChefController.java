package com.gustofusion.gestionemploye.controllers;

import com.gustofusion.gestionemploye.entities.Chef;
import com.gustofusion.gestionemploye.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/chef")
public class ChefController {
    @Autowired
    private ChefService chefService;
    @GetMapping("/{id}")
    public Chef  getChefById(@PathVariable Integer id) {
        return chefService.getChefById(id);
    }
    @GetMapping()
    public ResponseEntity<List<Chef>> retrieveAllChef(){
        List<Chef> chefs = chefService.getChef();
        return new ResponseEntity<>(chefs, HttpStatus.OK);
    }
    @PostMapping()
    public Chef createChef(@RequestBody Chef chef){
        return chefService.createChef(chef);
    }
    @PutMapping("/{id}")
    public void updateChef(@PathVariable Integer id, @RequestBody Chef chef) {
        chefService.updateChef(id, chef);
    }

    @DeleteMapping("/{id}")
    public void deleteChef(@PathVariable Integer id) {
        chefService.deleteChef(id);
    }
}
