package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {

    CartItems save(CartItems cartItems);
}
