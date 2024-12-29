package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.WishlistItems;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemsRepository extends JpaRepository<WishlistItems, Long> {

  WishlistItems save(WishlistItems wishlistItems);

  @Query(
      name = "select * from wishlist_items wt where wt.wishlist_id = :wishlistId",
      nativeQuery = true)
  List<WishlistItems> getWishlistItemsByWishlistId(@Param("wishlistId") Long wishlistId);
}
