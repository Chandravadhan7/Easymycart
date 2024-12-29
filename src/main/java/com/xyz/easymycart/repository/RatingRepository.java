package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Rating;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long> {

  @Query(value = "select * from rating r where r.id = :id", nativeQuery = true)
  Optional<Rating> getProductRating(@Param("id") Long id);
}
