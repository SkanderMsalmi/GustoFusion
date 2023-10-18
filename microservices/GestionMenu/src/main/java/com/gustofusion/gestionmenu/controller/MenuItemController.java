package com.gustofusion.gestionmenu.controller;

import com.gustofusion.gestionmenu.entities.Menu;
import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.services.MenuItemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/menuitems")
public class MenuItemController {
    @Autowired
    private MenuItemServiceInterface menuItemService;

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id) {
        return menuItemService.getMenuItemById(id);
    }

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenuItem(menuItem);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
        return menuItemService.updateMenuItem(id, menuItem);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
    }

    @PostMapping("/{menuItemId}/add-to-menu/{menuId}")
    public Menu addMenuItemToMenu(@PathVariable Long menuItemId, @PathVariable Long menuId) {
        return menuItemService.addMenuItemToMenu(menuId, menuItemId);
    }

    @PutMapping("/{menuItemId}/assign-category/{categoryId}")
    public MenuItem assignCategoryToMenuItem(@PathVariable Long menuItemId, @PathVariable Long categoryId) {
        return menuItemService.assignCategoryToMenuItem(menuItemId, categoryId);
    }
}
