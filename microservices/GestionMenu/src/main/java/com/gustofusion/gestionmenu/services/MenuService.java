package com.gustofusion.gestionmenu.services;

import com.gustofusion.gestionmenu.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MenuService implements  MenuServiceInterface {
    @Autowired
    private MenuRepository menuRepo;
}
