package com.gustofusion.gestionemploye.controllers;

import com.gustofusion.gestionemploye.services.SousChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/sousChef")
public class SousChefController {
    @Autowired
    private SousChefService sousChefService;

    @GetMapping()
    public String getHello() {return "hello sousChef";}
}
