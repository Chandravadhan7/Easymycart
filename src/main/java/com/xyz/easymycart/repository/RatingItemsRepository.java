package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.RatingItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingItemsRepository extends JpaRepository<RatingItems,Long> {
    @Query(value = "select * from product_ratings pr where pr.rating_id = :ratingId",nativeQuery = true)
      List<RatingItems> getRatingsByRatingId(@Param("ratingId") Long ratingId);
}
