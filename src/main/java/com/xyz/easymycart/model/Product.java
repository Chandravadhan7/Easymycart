package com.xyz.easymycart.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;
  @Column(name = "selling_price")
  private Integer sellingPrice;
  @Column(name = "original_price")
  private Integer originalPrice;
  private String description;

  //    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
  //    private Category category;
  private Long category_id;
  private String image;
  //    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
  //    private Rating rating;
  private Long rating_id;

  @Column(name = "product_type")
  private String productType;

  public Product() {}

  public Product(
      Long id,
      String title,
      Integer sellingPrice,
      String description,
      String image,
      Long category_id,
      Long rating_id,Integer originalPrice,String productType) {
    this.id = id;
    this.title = title;
    this.sellingPrice = sellingPrice;
    this.description = description;
    this.image = image;
    this.category_id = category_id;
    this.rating_id = rating_id;
    this.originalPrice = originalPrice;
    this.productType = productType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setSellingPrice(Integer sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Integer getSellingPrice() {
    return sellingPrice;
  }

  public String getDescription() {
    return description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Long getCategory_id() {
    return category_id;
  }

  public void setCategory_id(Long category_id) {
    this.category_id = category_id;
  }

  public Long getRating_id() {
    return rating_id;
  }

  public void setRating_id(Long rating_id) {
    this.rating_id = rating_id;
  }

  public Integer getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(Integer originalPrice) {
    this.originalPrice = originalPrice;
  }

  public String getProductType() {
    return productType;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
