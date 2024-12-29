package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(value = "select * from product", nativeQuery = true)
  List<Product> getAll();

  @Query(value = "select * from product where product.id = :id", nativeQuery = true)
  Optional<Product> getProduct(@Param("id") Long id);

  @Query(value = "select c.title from category c", nativeQuery = true)
  List<String> getAllCat();

  Product save(Product product);

  @Query(value = "select * from product p where p.category_id = :id", nativeQuery = true)
  List<Product> getProductsByCategory(@Param("id") Long id);
}
