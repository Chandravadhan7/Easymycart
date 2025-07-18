package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

  Order save(Order order);

  @Query(value = "select * from orders o where o.user_id = :userId",nativeQuery = true)
  List<Order> getOrderByUserId(@Param("userId") Long userId);
}
