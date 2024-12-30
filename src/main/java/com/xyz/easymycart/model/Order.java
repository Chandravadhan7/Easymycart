package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id",nullable = false)
    private String orderId;

    @Column(name = "cart_id",nullable = false)
    private Long cartId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "delivered_on")
    private Long DeliveredOn;

    public Order(){

    }
    public Order(Long id, String orderId, Long cartId, Long userId, Long deliveredOn) {
        this.id = id;
        this.orderId = orderId;
        this.cartId = cartId;
        this.userId = userId;
        DeliveredOn = deliveredOn;
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
        return DeliveredOn;
    }

    public void setDeliveredOn(Long deliveredOn) {
        DeliveredOn = deliveredOn;
    }
}
