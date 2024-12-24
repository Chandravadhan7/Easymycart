package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Wishlist;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Wishlist getOrCreateWishlist(HttpSession session){
        Long userId = (Long) session.getAttribute("user_id");

        System.out.println("User ID from session: " + userId);
        Wishlist wishlist = productService.getOrCreateWishlist(userId);
        return wishlist;
    }
}
