package com.gustofusion.gestionmenu.services;

import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.repositories.CategoryRepository;
import com.gustofusion.gestionmenu.repositories.MenuItemRepository;
import com.gustofusion.gestionmenu.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gustofusion.gestionmenu.entities.Menu;


import java.util.Collections;
import java.util.List;
@Service
public class MenuService implements  MenuServiceInterface {



    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private MenuRepository menuRepository ;
    @Autowired
    private CategoryRepository categoryRepository ;


    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Long id, Menu updatedMenu) {
        Menu existingMenu = getMenuById(id);
        if (existingMenu != null) {
            existingMenu.setName(updatedMenu.getName());
            existingMenu.setDescription(updatedMenu.getDescription());
            return menuRepository.save(existingMenu);
        }
        return null;
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> getMenuItemsByMenuId(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElse(null);
        if (menu != null) {
            return menu.getMenuItems();
        }
        return Collections.emptyList();
    }


    @Override
    public Menu removeMenuItemFromMenu(Long menuId, Long menuItemId) {
        Menu menu = menuRepository.findById(menuId).orElse(null);
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElse(null);

        if (menu != null && menuItem != null) {

            menu.getMenuItems().remove(menuItem);
            menuItem.getMenus().remove(menu);

            menuRepository.save(menu);
            menuItemRepository.save(menuItem);
        }

        return menu;
    }
}
