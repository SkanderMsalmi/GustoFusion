package com.gustofusion.gestionmenu.services;

import com.gustofusion.gestionmenu.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoryService  implements CategoryServiceInterface {
    @Autowired
    private CategoryRepository categoryRepo;
}
