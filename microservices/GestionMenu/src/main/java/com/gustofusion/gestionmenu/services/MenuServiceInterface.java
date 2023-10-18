package com.gustofusion.gestionmenu.services;

import com.gustofusion.gestionmenu.entities.Menu;
import com.gustofusion.gestionmenu.entities.MenuItem;

import java.util.List;

public interface MenuServiceInterface {
    List<Menu> getAllMenus();
    Menu getMenuById(Long id);
    Menu createMenu(Menu menu);
    Menu updateMenu(Long id, Menu menu);
    void deleteMenu(Long id);
    List<MenuItem> getMenuItemsByMenuId(Long menuId);
    Menu removeMenuItemFromMenu(Long menuId, Long menuItemId) ;
}
