package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "product_ratings")
public class RatingItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "stars")
    private Integer stars;
    @Column(name = "comment")
    private String comment;
    @Column(name = "review_data")
    private Long reviewDate;
    @Column(name = "reviewerName")
    private String reviewerName;
    @Column(name = "rating_id")
    private Long rating_id;

    public RatingItems(){

    }
    public RatingItems(Long id, Integer stars, String comment, Long reviewDate, String reviewerName, Long rating_id) {
        this.id = id;
        this.stars = stars;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.reviewerName = reviewerName;
        this.rating_id = rating_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Long reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Long getRating_id() {
        return rating_id;
    }

    public void setRating_id(Long rating_id) {
        this.rating_id = rating_id;
    }
}
