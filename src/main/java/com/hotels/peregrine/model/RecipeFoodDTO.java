package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 음식 레시피 재료(recipe_food) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★rfNo</b> 재료 번호 <b>Primary Key</b><br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★food.foodNo</b> 음식(food)테이블 <b>Primary Key, Foreign Key</b><br>
 * <b>material.matNo</b> 자재(material)테이블 <b>Foreign Key</b><br>
 * */
public class RecipeFoodDTO implements Serializable {
	private int rfNo;
	private FoodDTO food;
	private MaterialDTO material;
	public int getRfNo() {
		return rfNo;
	}
	public RecipeFoodDTO setRfNo(int rfNo) {
		this.rfNo = rfNo;
		return this;
	}
	public FoodDTO getFood() {
		return food;
	}
	public RecipeFoodDTO setFood(FoodDTO food) {
		this.food = food;
		return this;
	}
	public MaterialDTO getMaterial() {
		return material;
	}
	public RecipeFoodDTO setMaterial(MaterialDTO material) {
		this.material = material;
		return this;
	}
	
}
