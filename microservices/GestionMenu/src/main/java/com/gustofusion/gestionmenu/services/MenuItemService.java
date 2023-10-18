package com.gustofusion.gestionmenu.services;


import com.gustofusion.gestionmenu.entities.Category;
import com.gustofusion.gestionmenu.entities.Menu;
import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.repositories.CategoryRepository;
import com.gustofusion.gestionmenu.repositories.MenuItemRepository;
import com.gustofusion.gestionmenu.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MenuItemService implements MenuItemServiceInterface  {
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private MenuRepository menuRepository ;
    @Autowired
    private CategoryRepository categoryRepository ;


    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem updatedMenuItem) {
        MenuItem existingMenuItem = getMenuItemById(id);
        if (existingMenuItem != null) {
            existingMenuItem.setName(updatedMenuItem.getName());
            existingMenuItem.setDescription(updatedMenuItem.getDescription());
            existingMenuItem.setPrice(updatedMenuItem.getPrice());
            return menuItemRepository.save(existingMenuItem);
        }
        return null;
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }


    @Override
    public Menu addMenuItemToMenu(Long menuId, Long menuItemId) {
        Menu menu = menuRepository.findById(menuId).orElse(null);
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElse(null);

        if (menu != null && menuItem != null) {
            menu.getMenuItems().add(menuItem);
            menuRepository.save(menu);
        }

        return menu;
    }


    @Override
    public MenuItem assignCategoryToMenuItem(Long menuItemId, Long categoryId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (menuItem != null && category != null) {
            menuItem.setCategory(category);
            menuItemRepository.save(menuItem);
        }

        return menuItem;
    }


}
