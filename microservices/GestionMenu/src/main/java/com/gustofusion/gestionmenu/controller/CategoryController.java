package com.gustofusion.gestionmenu.controller;

import com.gustofusion.gestionmenu.entities.Category;
import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.services.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceInterface categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{categoryId}/menu-items")
    public List<MenuItem> getMenuItemsByCategoryId(@PathVariable Long categoryId) {
        return categoryService.getMenuItemsByCategoryId(categoryId);
    }
}
