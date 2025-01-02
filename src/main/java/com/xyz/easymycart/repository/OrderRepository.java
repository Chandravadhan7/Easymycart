package com.xyz.easymycart.repository;

import com.xyz.easymycart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

  Order save(Order order);
}
