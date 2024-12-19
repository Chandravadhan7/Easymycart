package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Cart;
import com.xyz.easymycart.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("cart")
public class CartController {
    private ProductService productService;

    @Autowired
    public CartController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/")
    public Cart getOrCreateCart(HttpSession session){
        Long userId = (Long) session.getAttribute("user_id");
        Cart cart = productService.getOrCreateCart(userId);
        return cart;
    }

}
