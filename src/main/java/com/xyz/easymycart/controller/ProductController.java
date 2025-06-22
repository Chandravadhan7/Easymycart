package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.*;
import com.xyz.easymycart.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Product>> getAllProducts() {
    try {
      List<Product> products = productService.getAllProducts();
      return new ResponseEntity<>(products, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/categories")
  public List<String> getAllCategories() {
    List<String> str = productService.getAllCategories();
    return str;
  }

  @GetMapping("/{id}")
  public Product getSingleProduct(@PathVariable("id") Long id) {
    Product product = productService.getSingleProduct(id);
    return product;
  }

  @GetMapping("/category/{id}")
  public Category getSingleCategory(@PathVariable("id") Long id) {
    Category category = productService.getSingleCategory(id);
    return category;
  }

  @PostMapping
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @GetMapping("/category's/{id}")
  public List<Product> getProductByCategory(@PathVariable("id") Long id) {
    List<Product> products = productService.getProductByCategory(id);
    return products;
  }

  @GetMapping("/category")
  public List<Category> getAllCategory() {
    List<Category> categories = productService.getAllCategory();
    return categories;
  }

  @GetMapping("/rating/{id}")
  public Rating getProductRating(@PathVariable("id") Long id) {
    Rating rating = productService.getProductRating(id);
    return rating;
  }

  @GetMapping("/ratings/{ratingId}")
  public List<RatingItems> getProductRatings(@PathVariable("ratingId") Long ratingId) {
    List<RatingItems> ratingItems = productService.getProductRatings(ratingId);
    return ratingItems;
  }

  @GetMapping("/api/search")
  public List<Product> getProductsByTitle(@RequestParam("searchValue") String title) {
    List<Product> products = productService.getProductsByTitle(title);
    return products;
  }

  @PostMapping("/recent")
  public ResponseEntity<String> addRecentProducts(
      @RequestHeader("userId") Long userId, @RequestParam("product_id") Long productId) {
    boolean added = productService.addRecentProducts(productId, userId);
    if (added) {
      return ResponseEntity.ok("product added successfully");
    } else {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("product already exist in recently added");
    }
  }

  @GetMapping("/recentlyViewed")
  public List<RecentlyViewed> getRecentlyViewedProducts(@RequestHeader("userId") Long userId) {
    List<RecentlyViewed> recentlyViewedList = productService.getRecentlyViewedProducts(userId);
    return recentlyViewedList;
  }
}
