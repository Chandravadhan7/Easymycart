package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Cart;
import com.xyz.easymycart.model.CartItems;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("cart")
public class CartController {
    private ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public Cart getOrCreateCart(HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        System.out.println("User ID from session: " + userId);
        Cart cart = productService.getOrCreateCart(userId);
        session.setAttribute("cartId",cart.getId());
        return cart;
    }

    @PostMapping("/cartitems")
    public CartItems addCartItem(@RequestBody CartItems cartItems1){
        CartItems cartItems = productService.addCartItem(cartItems1.getCart_id());
        return cartItems;
    }



//    @PostMapping("/")
//    public Cart getOrCreateCart(){
////        Long userId = (Long) session.getAttribute("user_id");
//        Cart cart = productService.getOrCreateCart(11L);
//        return cart;
//    }
//
}
