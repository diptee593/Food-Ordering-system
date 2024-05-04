package com.yummyfork.dto;

public class Food {

	private int foodId;
	private String foodName;
	private double foodPrice;
	private int foodQuantity;
	private String foodCategory;
	


	public Food() {
		super();
	}
	
	public Food(String foodName, double foodPrice, int foodQuantity, String foodCategory) {		//for insert
		super();
		System.out.println("inside constructor");
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.foodCategory = foodCategory;
	}

	public Food(int foodId, String foodName, double foodPrice, int foodQuantity, String foodCategory) {		//for update
		super();
		System.out.println("constructor");
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.foodCategory = foodCategory;
	}

	
	public Food(String foodName) {
		super();
		System.out.println("inside public Food(String foodName) constructor");
		this.foodName = foodName;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodQuantity="
				+ foodQuantity + ", foodCategory=" + foodCategory + "]";
	}

	
}
