package com.gustofusion.gestionmenu.controller;

import com.gustofusion.gestionmenu.entities.Menu;
import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.services.CategoryServiceInterface;
import com.gustofusion.gestionmenu.services.MenuServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuServiceInterface menuService ;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        return menuService.updateMenu(id, menu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }

    @GetMapping("/{menuId}/menu-items")
    public List<MenuItem> getMenuItemsByMenuId(@PathVariable Long menuId) {
        return menuService.getMenuItemsByMenuId(menuId);
    }

    @DeleteMapping("/{menuId}/menu-items/{menuItemId}")
    public Menu removeMenuItemFromMenu(@PathVariable Long menuId, @PathVariable Long menuItemId) {
        return menuService.removeMenuItemFromMenu(menuId, menuItemId);
    }
}
