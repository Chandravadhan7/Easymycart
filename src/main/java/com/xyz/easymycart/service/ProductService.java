package com.xyz.easymycart.service;

import com.xyz.easymycart.model.Category;
import com.xyz.easymycart.model.Product;
import com.xyz.easymycart.model.User;
import com.xyz.easymycart.repository.CategoryRepository;
import com.xyz.easymycart.repository.ProductRepository;
import com.xyz.easymycart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
       private ProductRepository productRepository;
       @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository,UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    private CategoryRepository categoryRepository;
    private UserRepository userRepository;



       public List<Product> getAllProducts(){
           List<Product> products = productRepository.getAll();
           return products;
       }

    public List<String> getAllCategories(){
           List<String> categories = productRepository.getAllCat();
           return categories;
       }
       public Product getSingleProduct(Long id){
           Optional<Product> optionalProduct = productRepository.getProduct(id);

           Product product = optionalProduct.get();
           return product;
       }
       public Category getSingleCategory(Long id){
           Optional<Category> optionalCategory = categoryRepository.getCategory(id);

           Category category = optionalCategory.get();
           return category;
       }

       public Product addProduct(Product product){
           Product product1 = productRepository.save(product);
           return product1;
       }

       public List<Product> getProductByCategory(Long id){
           List<Product> products = productRepository.getProductsByCategory(id);
           return products;
       }

       public  List<Category> getAllCategory(){
           List<Category> categories = categoryRepository.getAllCategories();
           return categories;
       }

       public User addUser(User user){
           User user1 = userRepository.save(user);
           return user1;
       }

       public User getUserDetails(Long id){
           User user = userRepository.getUserDetails(id);
           return user;
       }

       public User getUserByUserName(User user){
           User user1 = userRepository.getUserByUserName(user.getUserName());
           return user1;
       }
}
