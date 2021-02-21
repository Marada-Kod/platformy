package edu.uph.ii.lab1.repository;

import edu.uph.ii.lab1.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
