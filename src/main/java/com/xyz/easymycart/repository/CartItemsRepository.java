package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {

    CartItems save(CartItems cartItems);

    @Query(value = "select * from cart_items ct where ct.cart_id = :cartId and ct.product_id = :productId",nativeQuery = true)
    Optional<CartItems> findByCartIdAndProductId(Long cartId, Long productId);

    @Query(value = "select * from cart_items ct where ct.cart_id = :cartId",nativeQuery = true)
    List<CartItems> findByCartId(@Param("cartId") Long cartId);
}
