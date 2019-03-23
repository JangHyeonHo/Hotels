package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 음식(food) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★foodNo</b> 음식 번호 <b>Primary Key</b> <br>
 * <b>foodName</b> 음식 이름<br>
 * <b>foodPrice</b> 음식 금액<br>
 * <b>foodRecipe</b> 음식 만드는 법<br>
 * <b>foodRegist</b> 음식 메뉴 등록 여부<br>
 * <b>foodKind</b> 음식 종류<br>
 * <b>foodOriFileName</b> 음식 실제 사진<br>
 * <b>foodStoreFileName</b> 음식 저장 사진<br>
 * @version 1.3
 * */
public class FoodDTO implements Serializable {
	public static final String[] FOODREGISTKIND = {"등록중","대기중"};
	
	private int foodNo;
	private String foodName;
	private int foodPrice;
	private String foodRecipe;
	private String foodRegist;
	private String foodKind;
	private String foodOriFileName;
	private String foodStoreFileName;

	public int getFoodNo() {
		return foodNo;
	}
	public FoodDTO setFoodNo(int foodNo) {
		this.foodNo = foodNo;
		return this;
	}
	public String getFoodName() {
		return foodName;
	}
	public FoodDTO setFoodName(String foodName) {
		this.foodName = foodName;
		return this;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public FoodDTO setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
		return this;
	}
	public String getFoodRecipe() {
		return foodRecipe;
	}
	public FoodDTO setFoodRecipe(String foodRecipe) {
		this.foodRecipe = foodRecipe;
		return this;
	}
	public String getFoodRegist() {
		return foodRegist;
	}
	public FoodDTO setFoodRegist(String foodRegist) {
		this.foodRegist = foodRegist;
		return this;
	}
	public String getFoodKind() {
		return foodKind;
	}
	public FoodDTO setFoodKind(String foodKind) {
		this.foodKind = foodKind;
		return this;
	}
	public String getFoodOriFileName() {
		return foodOriFileName;
	}
	public FoodDTO setFoodOriFileName(String foodOriFileName) {
		this.foodOriFileName = foodOriFileName;
		return this;
	}
	public String getFoodStoreFileName() {
		return foodStoreFileName;
	}
	public FoodDTO setFoodStoreFileName(String foodStoreFileName) {
		this.foodStoreFileName = foodStoreFileName;
		return this;
	}
	
}
