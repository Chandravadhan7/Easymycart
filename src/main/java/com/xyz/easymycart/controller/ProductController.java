package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Category;
import com.xyz.easymycart.model.Product;
import com.xyz.easymycart.model.User;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

//    @GetMapping("/")
//    public List<Product> getAllProducts(){
//        List<Product> products = productService.getAllProducts();
//        return products;
//    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
//        logger.info("Fetching all products");
        try {
            List<Product> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
//            logger.error("Error fetching products", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/")
//    public List<Product> getAllProducts() {
//        return List.of(new Product(1L, "Sample Product", 99,"desctip","img"));
//    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        List<String> str = productService.getAllCategories();
        return str;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        Product product = productService.getSingleProduct(id);
        return product;
    }

    @GetMapping("/category/{id}")
    public Category getSingleCategory(@PathVariable("id") Long id){
        Category category = productService.getSingleCategory(id);
        return category;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/category's/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") Long id){
        List<Product> products = productService.getProductByCategory(id);
        return products;
    }

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        List<Category> categories = productService.getAllCategory();
        return categories;
    }




}
