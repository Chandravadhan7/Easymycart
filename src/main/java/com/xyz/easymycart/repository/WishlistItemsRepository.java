package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.WishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemsRepository extends JpaRepository<WishlistItems,Long> {
}
