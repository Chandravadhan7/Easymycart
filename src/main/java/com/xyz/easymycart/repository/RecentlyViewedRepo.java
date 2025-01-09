package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.RecentlyViewed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentlyViewedRepo extends JpaRepository<RecentlyViewed,Long> {

   RecentlyViewed save(RecentlyViewed recentlyViewed);

   @Query(value = "select * from recently_viewed r where r.product_id = :productId and r.user_id = :userId",nativeQuery = true)
   boolean findByUserIdAndProductId(@Param("productId") Long productId, @Param("userId") Long userId);
}
