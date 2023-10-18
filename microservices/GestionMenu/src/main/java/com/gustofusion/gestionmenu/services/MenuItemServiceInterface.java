package com.gustofusion.gestionmenu.services;

import com.gustofusion.gestionmenu.entities.Menu;
import com.gustofusion.gestionmenu.entities.MenuItem;

import java.util.List;

public interface MenuItemServiceInterface {
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(Long id);
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
    void deleteMenuItem(Long id);

    Menu addMenuItemToMenu(Long menuId, Long menuItemId);

    MenuItem assignCategoryToMenuItem(Long menuItemId, Long categoryId) ;
}
