package com.momsdeli.online.repository;

import com.momsdeli.online.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM categories WHERE id = :id", nativeQuery = true)
    Category findCategoryById(@Param("id") Long id);

    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    List<Category> findAllCategories();

    @Query(value = "SELECT * FROM categories WHERE name LIKE %:name%", nativeQuery = true)
    List<Category> findCategoriesByName(@Param("name") String name);

    /**
     * Finds a category by its name.
     *
     * @param name the name of the category
     * @return an Optional containing the category if found, or empty if not found
     */
    Optional<Category> findByName(String name);

}
