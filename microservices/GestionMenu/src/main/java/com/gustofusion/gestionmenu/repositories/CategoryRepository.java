package com.gustofusion.gestionmenu.repositories;

import com.gustofusion.gestionmenu.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}







