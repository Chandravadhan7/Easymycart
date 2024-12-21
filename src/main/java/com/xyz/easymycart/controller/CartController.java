package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Cart;
import com.xyz.easymycart.model.CartItems;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RestController
@RequestMapping("cart")
public class CartController {
    private ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Cart getOrCreateCart(HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");

        if (userId == null) {
            throw new RuntimeException("User not logged in. Cannot create or retrieve cart.");
        }

        System.out.println("User ID from session: " + userId);

        Cart cart = productService.getOrCreateCart(userId);
        session.setAttribute("cartId", cart.getId());
        return cart;
    }

    @PostMapping("/{cartId}/cartitems")
    public CartItems addCartItem(
            @PathVariable("cartId") Long cartId,
            @RequestParam("product_id") Long productId,
            @RequestParam("quantity") int quantity) {
        return productService.addCartItem(cartId, productId, quantity);
    }

    @GetMapping("/{cartId}")
    public List<CartItems> getCartItems(@PathVariable("cartId") Long cartId){
        List<CartItems> cartItems= productService.getCartItemsByCartId(cartId);
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
