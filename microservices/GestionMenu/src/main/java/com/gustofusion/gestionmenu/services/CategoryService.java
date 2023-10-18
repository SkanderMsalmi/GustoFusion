package com.gustofusion.gestionmenu.services;

import com.gustofusion.gestionmenu.entities.Category;
import com.gustofusion.gestionmenu.entities.MenuItem;
import com.gustofusion.gestionmenu.repositories.CategoryRepository;
import com.gustofusion.gestionmenu.repositories.MenuItemRepository;
import com.gustofusion.gestionmenu.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class CategoryService  implements CategoryServiceInterface {
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private MenuRepository menuRepository ;
    @Autowired
    private CategoryRepository categoryRepository ;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = getCategoryById(id);
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> getMenuItemsByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            return category.getMenuItems();
        }
        return Collections.emptyList();
    }
}
