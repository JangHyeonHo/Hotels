package com.hotels.peregrine.command;

import org.springframework.web.multipart.MultipartFile;

import com.hotels.peregrine.model.FoodDTO;

public class FoodRegistCommand {
	private FoodDTO food;
	private int[] materialNo;
	MultipartFile foodImage;
	public FoodDTO getFood() {
		return food;
	}
	public void setFood(FoodDTO food) {
		this.food = food;
	}
	public int[] getMaterialNo() {
		return materialNo;
	}
	public void setMaterialNo(int[] materialNo) {
		this.materialNo = materialNo;
	}
	public MultipartFile getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(MultipartFile foodImage) {
		this.foodImage = foodImage;
	}
	
}
