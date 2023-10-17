package com.gustofusion.gestionmenu.services;


import com.gustofusion.gestionmenu.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MenuItemService implements MenuItemServiceInterface  {
    @Autowired
    private MenuItemRepository menuItemRepo;
}
