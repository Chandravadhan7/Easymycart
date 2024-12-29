package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "wishlist_items")
public class WishlistItems {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "wishlist_id", nullable = false)
  private Long wishlistId;

  public WishlistItems(Long id, Long productId, Long wishListId) {
    this.id = id;
    this.productId = productId;
    this.wishlistId = wishListId;
  }

  public WishlistItems() {}

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Long getProductId() {
    return productId;
  }

  public Long getWishListId() {
    return wishlistId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setWishListId(Long wishListId) {
    this.wishlistId = wishListId;
  }
}
