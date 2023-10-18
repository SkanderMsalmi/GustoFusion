package com.gustofusion.gestionmenu.services;


import com.gustofusion.gestionmenu.entities.Category;
import com.gustofusion.gestionmenu.entities.MenuItem;

import java.util.List;

public interface CategoryServiceInterface  {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);

    List<MenuItem> getMenuItemsByCategoryId(Long categoryId);
}


