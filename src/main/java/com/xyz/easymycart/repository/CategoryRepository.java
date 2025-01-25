package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query(value = "select * from category", nativeQuery = true)
  List<Category> getAllCategories();

  @Query(value = "select * from category c where c.id = :id", nativeQuery = true)
  Optional<Category> getCategory(@Param("id") Long id);
}
