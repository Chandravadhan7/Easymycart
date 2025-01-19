package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "order_id", nullable = false)
  private String orderId;

  @Column(name = "cart_id", nullable = false)
  private Long cartId;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "delivered_on")
  private Long deliveredOn;

  @Column(name = "ordered_on")
  private Long orderedOn;

  @Column(name = "address_id")
  private Long addressId;

  public Order() {}

  public Order(Long id, String orderId, Long cartId, Long userId, Long deliveredOn, Long orderedOn, Long addressId) {
    this.id = id;
    this.orderId = orderId;
    this.cartId = cartId;
    this.userId = userId;
    this.deliveredOn = deliveredOn;
    this.orderedOn = orderedOn;
      this.addressId = addressId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Long getCartId() {
    return cartId;
  }

  public void setCartId(Long cartId) {
    this.cartId = cartId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getDeliveredOn() {
    return deliveredOn;
  }

  public void setDeliveredOn(Long deliveredOn) {
    this.deliveredOn = deliveredOn;
  }

  public Long getOrderedOn() {
    return orderedOn;
  }

  public void setOrderedOn(Long orderedOn) {
    this.orderedOn = orderedOn;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }
}
