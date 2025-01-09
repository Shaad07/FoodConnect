package com.example.foodconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "afssc")
public class Afssc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "afssc_id")
    private Long afsscId;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "donor_id")
    private Long donorId;

    @Column(name = "user_id")
    private Long userId;

    // Getters and Setters
    public Long getAfsscId() {
        return afsscId;
    }

    public void setAfsscId(Long afsscId) {
        this.afsscId = afsscId;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
