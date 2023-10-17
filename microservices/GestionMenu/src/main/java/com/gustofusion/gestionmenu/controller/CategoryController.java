package com.gustofusion.gestionmenu.controller;

import com.gustofusion.gestionmenu.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryServiceInterface CategoryServ;
}
