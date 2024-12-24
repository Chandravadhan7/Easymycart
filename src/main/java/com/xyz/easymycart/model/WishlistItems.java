package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "wishlist_items")
public class WishlistItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_id",nullable = false)
    private Long productId;
    @Column(name = "wishlist_id",nullable = false)
    private Long WishListId;
}
