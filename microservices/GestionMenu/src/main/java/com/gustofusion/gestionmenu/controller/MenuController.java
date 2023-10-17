package com.gustofusion.gestionmenu.controller;

import com.gustofusion.gestionmenu.services.CategoryServiceInterface;
import com.gustofusion.gestionmenu.services.MenuServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Menu")
public class MenuController {
    @Autowired
    private MenuServiceInterface MenuServ;
}
