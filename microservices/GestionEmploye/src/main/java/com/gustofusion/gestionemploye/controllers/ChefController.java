package com.gustofusion.gestionemploye.controllers;

import com.gustofusion.gestionemploye.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/chef")
public class ChefController {
    @Autowired
    private ChefService chefService;

    @GetMapping()
    public String getHello() {return "hello chef";}
}
