package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Full_Name",nullable = false)
    private String fullName;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "pin_code",nullable = false)
    private String pinCode;
    @Column(name = "Flat_Number",nullable = false)
    private String flatNumber;
    @Column(name = "Area",nullable = false)
    private String area;
    @Column(name = "village",nullable = false)
    private String village;
    @Column(name = "user_id",nullable = false)
    private Long userId;
    public Address(Long id, String fullName, String phone, String pinCode, String flatNumber, String area, String village, Long userId){

        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.pinCode = pinCode;
        this.flatNumber = flatNumber;
        this.area = area;
        this.village = village;
        this.userId = userId;
    }

    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getArea() {
        return area;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
