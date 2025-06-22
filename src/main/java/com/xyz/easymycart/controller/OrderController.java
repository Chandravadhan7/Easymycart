package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Order;
import com.xyz.easymycart.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

  private ProductService productService;

  public OrderController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/{cartId}")
  public Order addOrder(
      @RequestHeader Long userId,
      @PathVariable("cartId") Long cartId,
      @RequestParam("address_id") Long addressId) {
    Order order = productService.addOrder(cartId, userId, addressId);
    return order;
  }

  @GetMapping("/")
  public List<Order> getUserOrders(@RequestHeader("userId") Long userId) {
    List<Order> orderList = productService.getUserOrders(userId);
    return orderList;
  }
}
