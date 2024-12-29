package com.xyz.easymycart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItems {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long cart_id;

  @Column(name = "product_id", nullable = false)
  @JsonProperty("product_id")
  private Long productId;

  private Integer quantity;

  public CartItems() {}

  public CartItems(Long id, Long cartId, Integer quantity, Long productId) {
    this.id = id;
    cart_id = cartId;
    this.quantity = quantity;
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getCart_id() {
    return cart_id;
  }

  public void setCart_id(Long cart_id) {
    this.cart_id = cart_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }
}
