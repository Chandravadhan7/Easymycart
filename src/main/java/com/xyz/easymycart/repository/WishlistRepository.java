package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Long> {
    Wishlist save(Wishlist wishlist);

    @Query(value = "select * from wishlist w where w.user_id = :userId",nativeQuery = true)
    Wishlist findWishlistByUserId(@Param("userId") Long userId);
}
