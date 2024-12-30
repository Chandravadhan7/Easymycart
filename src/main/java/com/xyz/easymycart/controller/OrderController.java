package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Order;
import com.xyz.easymycart.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private ProductService productService;

    public OrderController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/{cartId}")
    public Order addOrder(@RequestHeader Long userId, @PathVariable("cartId") Long cartId){
        Order order = productService.addOrder(cartId,userId);
        return order;
    }
}
