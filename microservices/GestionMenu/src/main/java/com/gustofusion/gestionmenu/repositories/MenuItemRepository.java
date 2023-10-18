package com.gustofusion.gestionmenu.repositories;

import com.gustofusion.gestionmenu.entities.Category;
import com.gustofusion.gestionmenu.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
