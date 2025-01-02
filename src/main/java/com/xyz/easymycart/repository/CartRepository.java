package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Cart;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

  Cart save(Cart cart);

  @Query(
      value = "select * from cart c where c.user_id = :userId and c.status = :string",
      nativeQuery = true)
  Cart findByUserIdAndStatus(@Param("userId") Long userId, @Param("string") String string);

  @Query(value = "update cart c set c.status = :status where c.id = :cartId", nativeQuery = true)
  @Modifying
  @Transactional
  void updateStatus(@Param("cartId") Long cartId, @Param("status") String status);
}
