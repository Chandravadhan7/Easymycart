package com.xyz.easymycart.service;

import com.xyz.easymycart.model.*;
import com.xyz.easymycart.repository.*;
import com.xyz.easymycart.repository.RecentlyViewedRepo;
import com.xyz.easymycart.request.AddressRequestDto;
import com.xyz.easymycart.request.LoginRequestDto;
import com.xyz.easymycart.response.LoginResponseDto;
import com.xyz.easymycart.utilities.UniqueHelper;
import com.xyz.easymycart.utilities.UtilityHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final RatingRepository ratingRepository;
  private final CartRepository cartRepository;
  private final CartItemsRepository cartItemsRepository;
  private final WishlistRepository wishlistRepository;
  private final WishlistItemsRepository wishlistItemsRepository;
  private final CategoryRepository categoryRepository;
  private final UserRepository userRepository;
  private final SessionRepository sessionRepository;
  private final OrderRepository orderRepository;
  private final AddressRepository addressRepository;
  private final RecentlyViewedRepo recentlyViewedRepo;
  private final RatingItemsRepository ratingItemsRepository;

  @Autowired
  public ProductService(
          ProductRepository productRepository,
          CategoryRepository categoryRepository,
          UserRepository userRepository,
          RatingRepository ratingRepository,
          CartRepository cartRepository,
          CartItemsRepository cartItemsRepository,
          WishlistRepository wishlistRepository,
          WishlistItemsRepository wishlistItemsRepository,
          SessionRepository sessionRepository,
          OrderRepository orderRepository, AddressRepository addressRepository, RecentlyViewedRepo recentlyViewedRepo, RatingItemsRepository ratingItemsRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
    this.userRepository = userRepository;
    this.ratingRepository = ratingRepository;
    this.cartRepository = cartRepository;
    this.cartItemsRepository = cartItemsRepository;
    this.wishlistRepository = wishlistRepository;
    this.wishlistItemsRepository = wishlistItemsRepository;
    this.sessionRepository = sessionRepository;
    this.orderRepository = orderRepository;
      this.addressRepository = addressRepository;
      this.recentlyViewedRepo = recentlyViewedRepo;
      this.ratingItemsRepository = ratingItemsRepository;
  }

  public List<Product> getAllProducts() {
    List<Product> products = productRepository.getAll();
    return products;
  }
  public List<Product> getProductsByTitle(String title){
    List<Product> products = productRepository.getProductsByTitle(title);
    return products;
  }
  public List<String> getAllCategories() {
    List<String> categories = productRepository.getAllCat();
    return categories;
  }

  public Product getSingleProduct(Long id) {
    Optional<Product> optionalProduct = productRepository.getProduct(id);

    Product product = optionalProduct.get();
    return product;
  }

  public Category getSingleCategory(Long id) {
    Optional<Category> optionalCategory = categoryRepository.getCategory(id);

    Category category = optionalCategory.get();
    return category;
  }

  public Product addProduct(Product product) {
    Product product1 = productRepository.save(product);
    return product1;
  }

  public List<Product> getProductByCategory(Long id) {
    List<Product> products = productRepository.getProductsByCategory(id);
    return products;
  }

  public List<Category> getAllCategory() {
    List<Category> categories = categoryRepository.getAllCategories();
    return categories;
  }

  public User addUser(User user) {
    User user1 = userRepository.save(user);
    return user1;
  }

  public User getUserDetails(Long id) {
    User user = userRepository.getUserDetails(id);
    return user;
  }

  public User getUserByUserName(User user) {
    User user1 = userRepository.getUserByUserName(user.getUserName());
    return user1;
  }

  public LoginResponseDto login(LoginRequestDto loginRequestDto) throws Exception {
    User user = userRepository.getUserByUserName(loginRequestDto.getUserName());
    if (user.getPassword().equals(loginRequestDto.getPassword())) {

      Session session =
          new Session(
              UniqueHelper.getSessionId(),
              user.getId(),
              UtilityHelper.getCurrentMillis() + TimeUnit.DAYS.toMillis(1),
              "active");

      Session ses = sessionRepository.save(session);
      return new LoginResponseDto(ses.getSessionId(), ses.getExpiresAt(), user.getId());
    } else throw new Exception("Invalid credits");
  }

  public Session getValidSession(String sessionId) throws Exception {
    Long currentTime = System.currentTimeMillis();
    Session session =
        sessionRepository.findBySessionIdAndStatusAndExpiresAtGreaterThan(sessionId, currentTime);
    if (session == null) {
      throw new Exception("Invalid or expired session");
    }
    return session;
  }

  public void logout(String sessionId) {
    Session session = sessionRepository.findByValueAndStatus(sessionId, "active");
    session.setStatus("logged out");
    sessionRepository.save(session);
    return;
  }

  public Rating getProductRating(Long id) {
    Optional<Rating> optionalRating = ratingRepository.getProductRating(id);
    Rating rating = optionalRating.get();
    return rating;
  }

  public List<RatingItems> getProductRatings(Long ratingId){
    List<RatingItems> ratingItems = ratingItemsRepository.getRatingsByRatingId(ratingId);
    return ratingItems;
  }

  public Cart getOrCreateCart(Long userId) {
    Cart existingCart = cartRepository.findByUserIdAndStatus(userId, "active");
    if (existingCart != null) {
      return existingCart;
    }

    Cart cart = new Cart();
    cart.setUserId(userId);
    cart.setStatus("active");
    return cartRepository.save(cart);
  }

  public void updateStatus(Long cartId, String status) {
    cartRepository.updateStatus(cartId, status);
    return;
  }

  public CartItems addCartItem(Long cartId, Long productId, int quantity) {
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

  public List<CartItems> getCartItemsByCartId(Long cartId) {
    List<CartItems> cartItems = cartItemsRepository.findByCartId(cartId);
    return cartItems;
  }

  public CartItems getCartItem(Long cartId, Long productId) {
    CartItems cartItem = cartItemsRepository.findByCartIdAndProductId(cartId, productId);
    return cartItem;
  }

  public void removeFromCart(Long productId) {
    cartItemsRepository.removeFromCart(productId);
  }

  public void increment(Long productId) {
    cartItemsRepository.increment(productId);
  }

  public void decrement(Long productId) {
    cartItemsRepository.decrement(productId);
  }

  public Wishlist getOrCreateWishlist(Long userId) {
    Wishlist existingWishlist = wishlistRepository.findWishlistByUserId(userId);
    if (existingWishlist != null) {
      return existingWishlist;
    }
    Wishlist wishlist = new Wishlist();
    wishlist.setUserId(userId);
    return wishlistRepository.save(wishlist);
  }

  public WishlistItems addWishlistItem(Long wishlistId, Long productId) {
    WishlistItems wishlistItem = new WishlistItems();
    wishlistItem.setProductId(productId);
    wishlistItem.setWishListId(wishlistId);
    return wishlistItemsRepository.save(wishlistItem);
  }

  public List<WishlistItems> getWishlistItemsByWishId(Long wishlistId) {
    List<WishlistItems> wishlistItems =
        wishlistItemsRepository.getWishlistItemsByWishlistId(wishlistId);
    return wishlistItems;
  }

  public Order addOrder(Long cartId, Long userId,Long addressId) {

    Order order = new Order();
    order.setOrderId(UniqueHelper.getOrderID());
    order.setUserId(userId);
    order.setCartId(cartId);
    order.setOrderedOn(UtilityHelper.getCurrentMillis());
    order.setDeliveredOn(UtilityHelper.getCurrentMillis()+TimeUnit.DAYS.toMillis(1));
    order.setAddressId(addressId);
    return orderRepository.save(order);
  }

  public List<Order> getUserOrders(Long userId){
    List<Order> orderList = orderRepository.getOrderByUserId(userId);
    return orderList;
  }

  public Address addAddress(AddressRequestDto addressRequestDto,Long userId){
      Address address = new Address();
      address.setArea(addressRequestDto.getArea());
      address.setPhone(addressRequestDto.getPhone());
      address.setFlatNumber(addressRequestDto.getFlatNumber());
      address.setFullName(addressRequestDto.getFullName());
      address.setPinCode(addressRequestDto.getPinCode());
      address.setVillage(addressRequestDto.getVillage());
      address.setLandMark(addressRequestDto.getLandMark());
      address.setDistrict(addressRequestDto.getDistrict());
      address.setState(addressRequestDto.getState());
      address.setUserId(userId);
      return addressRepository.save(address);
  }
  public void updateUserAddress(Long id,AddressRequestDto addressRequestDto){
    addressRepository.updateAddressById(id, addressRequestDto.getFullName(), addressRequestDto.getPhone(), addressRequestDto.getPinCode(), addressRequestDto.getFlatNumber(), addressRequestDto.getArea(), addressRequestDto.getVillage(), addressRequestDto.getLandMark(), addressRequestDto.getDistrict(), addressRequestDto.getState());
      return ;
  }
  public List<Address> getUserAddress(Long userId){
    List<Address> addressList =  addressRepository.findAddressByUserId(userId);
    return addressList;
  }
  public Address getAddress(Long id){
    Address address = addressRepository.findAddressById(id);
    return address;
  }

  public boolean addRecentProducts(Long productId,Long userId){
    Optional<RecentlyViewed> optionalRecentlyViewed = recentlyViewedRepo.findByUserIdAndProductId(productId,userId);
    if(!optionalRecentlyViewed.isPresent()){
        RecentlyViewed recentlyViewed = new RecentlyViewed();
        recentlyViewed.setProductId(productId);
        recentlyViewed.setUserId(userId);
        recentlyViewedRepo.save(recentlyViewed);
        return true;
    }
    return false;
  }

  public List<RecentlyViewed> getRecentlyViewedProducts(Long userId){
    List<RecentlyViewed> recentlyViewedList = recentlyViewedRepo.getRecentlyViewedByUserId(userId);
    return recentlyViewedList;
  }

}
