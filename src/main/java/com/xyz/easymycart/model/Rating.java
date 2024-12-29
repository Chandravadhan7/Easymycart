package com.xyz.easymycart.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "rating")
public class Rating implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Float score;
  private Integer rate_count;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  public Integer getRate_count() {
    return rate_count;
  }

  public void setRate_count(Integer rate_count) {
    this.rate_count = rate_count;
  }

  public Rating() {}

  public Rating(Long id, Float score, Integer rate_count) {
    this.id = id;
    this.score = score;
    this.rate_count = rate_count;
  }
}
