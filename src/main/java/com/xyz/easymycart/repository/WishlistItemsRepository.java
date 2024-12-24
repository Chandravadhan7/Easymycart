package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.WishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemsRepository extends JpaRepository<WishlistItems,Long> {

    WishlistItems save(WishlistItems wishlistItems);

    @Query(name = "select * from wishlist_items wt where wt.wishlist_id = :wishlistId",nativeQuery = true)
    List<WishlistItems> getWishlistItemsByWishlistId(@Param("wishlistId") Long wishlistId);

}
