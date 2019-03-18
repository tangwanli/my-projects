package com.ros.bean;

public class Foodtype {
    private Integer foodtypeId;

    private String foodtypeName;

    public Integer getFoodtypeId() {
        return foodtypeId;
    }

    public void setFoodtypeId(Integer foodtypeId) {
        this.foodtypeId = foodtypeId;
    }

    public String getFoodtypeName() {
        return foodtypeName;
    }

    public void setFoodtypeName(String foodtypeName) {
        this.foodtypeName = foodtypeName == null ? null : foodtypeName.trim();
    }
}