package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "wishlist")
public class Wishlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  public Wishlist(Long id, Long userId) {
    this.id = id;
    this.userId = userId;
  }

  public Wishlist() {}

  public Long getId() {
    return id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
