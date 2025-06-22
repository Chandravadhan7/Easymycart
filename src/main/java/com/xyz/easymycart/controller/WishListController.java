package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Wishlist;
import com.xyz.easymycart.model.WishlistItems;
import com.xyz.easymycart.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
  @Autowired private ProductService productService;

  @GetMapping("/")
  public Wishlist getOrCreateWishlist(@RequestHeader Long userId) {
    //    Long userId = (Long) session.getAttribute("user_id");

    System.out.println("User ID from session: " + userId);
    Wishlist wishlist = productService.getOrCreateWishlist(userId);
    return wishlist;
  }

  @PostMapping("/{wishlistId}/wishlistitems")
  public WishlistItems addWishListItems(
      @PathVariable("wishlistId") Long wishlistId, @RequestParam Long productId) {
    WishlistItems wishlistItems = productService.addWishlistItem(wishlistId, productId);
    return wishlistItems;
  }

  @GetMapping("/{wishlistId}")
  public List<WishlistItems> getWishlistItemsByWishId(@PathVariable("wishlistId") Long wishlistId) {
    List<WishlistItems> wishlistItems = productService.getWishlistItemsByWishId(wishlistId);
    return wishlistItems;
  }
}
