package com.gustofusion.gestionemploye.controllers;

import com.gustofusion.gestionemploye.services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/livreur")
public class LivreurController {
    @Autowired
    private LivreurService livreurService;

    @GetMapping()
    public String getHello() {return "hello livreur";}
}
