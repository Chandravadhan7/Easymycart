package com.xyz.easymycart.service;

import com.xyz.easymycart.model.*;
import com.xyz.easymycart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
       private RatingRepository ratingRepository;
       private CartRepository cartRepository;
       private CartItemsRepository cartItemsRepository;
       @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository, RatingRepository ratingRepository, CartRepository cartRepository, CartItemsRepository cartItemsRepository) {
           this.productRepository = productRepository;
           this.categoryRepository = categoryRepository;
           this.userRepository = userRepository;
           this.ratingRepository = ratingRepository;
           this.cartRepository = cartRepository;
           this.cartItemsRepository = cartItemsRepository;
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

       public Rating getProductRating(Long id){
           Optional<Rating> optionalRating = ratingRepository.getProductRating(id);
           Rating rating = optionalRating.get();
           return rating;
       }

       public Cart getOrCreateCart(Long userId){
           Cart existingCart = cartRepository.findByUserIdAndStatus(userId,"active");
           if(existingCart != null){
               return existingCart;
           }

           Cart cart = new Cart();
           cart.setUserId(userId);
           cart.setStatus("active");
           return cartRepository.save(cart);
       }

       public CartItems addCartItem(Long cartId, Long productId, int quantity){
           if (cartId == null || productId == null) {
               throw new IllegalArgumentException("Cart ID and Product ID cannot be null");
           }

           if (!cartRepository.existsById(cartId)) {
               throw new IllegalArgumentException("Cart does not exist for ID: " + cartId);
           }

           if (!productRepository.existsById(productId)) {
               throw new IllegalArgumentException("Product does not exist for ID: " + productId);
           }

           CartItems cartItems = new CartItems();
           cartItems.setCart_id(cartId);
           cartItems.setProductId(productId);
           cartItems.setQuantity(quantity);
           return cartItemsRepository.save(cartItems);
       }

       public List<CartItems> getCartItemsByCartId(Long cartId){
           List<CartItems> cartItems = cartItemsRepository.findByCartId(cartId);
           return cartItems;
       }

       public void removeFromCart(Long productId){
           cartItemsRepository.removeFromCart(productId);
       }

       public void increment(Long productId){
           cartItemsRepository.increment(productId);
       }

       public void decrement(Long productId){
           cartItemsRepository.decrement(productId);
       }
}
