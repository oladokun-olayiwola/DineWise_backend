package com.example.dinewise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meals_combo")
public class Meal {

    @Id
    private int id;

    private int price;

    private String healthScore;

    private String imageUrl;

    @Column(name = "food_combination")
    private String foodCombination;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(String healthScore) {
        this.healthScore = healthScore;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFoodCombination() {
        return foodCombination;
    }

    public void setFoodCombination(String foodCombination) {
        this.foodCombination = foodCombination;
    }
}
