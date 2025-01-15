package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Cart;
import com.xyz.easymycart.model.CartItems;
import com.xyz.easymycart.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("cart")
public class CartController {
  private ProductService productService;

  @Autowired
  public CartController(ProductService productService) {
    this.productService = productService;
  }

  //    @GetMapping("/")
  //    public Cart getOrCreateCart(HttpSession session) {
  //        Long userId = (Long) session.getAttribute("user_id");
  //
  //        if (userId == null) {
  //            throw new RuntimeException("User not logged in. Cannot create or retrieve cart.");
  //        }
  //
  //        System.out.println("User ID from session: " + userId);
  //
  //        Cart cart = productService.getOrCreateCart(userId);
  //        return cart;
  //    }

  @GetMapping("/")
  public Cart getOrCreateCart(@RequestHeader("userId") Long userId) {
    //        Long userId = (Long) session.getAttribute("user_id");

    if (userId == null) {
      throw new RuntimeException("User not logged in. Cannot create or retrieve cart.");
    }

    System.out.println("User ID from session: " + userId);

    Cart cart = productService.getOrCreateCart(userId);
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
  public List<CartItems> getCartItems(@PathVariable("cartId") Long cartId) {
    List<CartItems> cartItems = productService.getCartItemsByCartId(cartId);
    return cartItems;
  }

  @GetMapping("/{cartId}/{productId}")
  public CartItems getCartItem(
      @PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId) {
    CartItems cartItem = productService.getCartItem(cartId, productId);
    return cartItem;
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<String> removeFromCart(@PathVariable("productId") Long productId) {
    try {
      productService.removeFromCart(productId);
      return ResponseEntity.ok("Product removed successfully.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Failed to remove product from cart: " + e.getMessage());
    }
  }

  @PatchMapping("/cartitems/{productId}/increment")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void increment(@PathVariable("productId") Long productId) {
    productService.increment(productId);
  }

  @PatchMapping("cartitems/{productId}/decrement")
  void decrement(@PathVariable("productId") Long productId) {
    productService.decrement(productId);
  }

  @PatchMapping("{cartId}/status")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void updateStatus(@PathVariable("cartId") Long cartId, String status) {
    productService.updateStatus(cartId, "completed");
  }
}
