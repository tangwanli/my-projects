package com.ros.bean;

public class Food {
    private Integer foodId;

    private Integer foodtypeId;

    private String foodName;

    private Integer foodPrice;

    private String foodImage;

    private Integer foodOrdertimes;

    @Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodtypeId=" + foodtypeId + ", foodName=" + foodName + ", foodPrice="
				+ foodPrice + ", foodImage=" + foodImage + ", foodOrdertimes=" + foodOrdertimes + "]";
	}

	public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodtypeId() {
        return foodtypeId;
    }

    public void setFoodtypeId(Integer foodtypeId) {
        this.foodtypeId = foodtypeId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage == null ? null : foodImage.trim();
    }

    public Integer getFoodOrdertimes() {
        return foodOrdertimes;
    }

    public void setFoodOrdertimes(Integer foodOrdertimes) {
        this.foodOrdertimes = foodOrdertimes;
    }
}