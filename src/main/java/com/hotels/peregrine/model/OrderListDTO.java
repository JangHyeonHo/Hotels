package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 주문 리스트(order list) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>olNo</b> 주문 리스트 번호<br>
 * <b>olCount</b> 주문 수량<br>
 * <b>olTime</b> 주문 시간<br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>관계 테이블</b><br>
 * <b>★orders.ordNo</b> 주문(orders)테이블 <b>Primary Key, Foreign key</b><br>
 * <b>★food.foodNo</b> 음식(food)테이블 <b>Primary Key, Foreign key</b><br>
 * @version 1.9
 * */
public class OrderListDTO implements Serializable {
	private int olNo;
	private int olCount;
	private Date olTime;
	private int olOldCount;
	private String foodName;
	private OrdersDTO orders;
	private FoodDTO food;
	private List<FoodDTO> foods;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getOlNo() {
		return olNo;
	}
	public void setOlNo(int olNo) {
		this.olNo = olNo;
	}
	public int getOlCount() {
		return olCount;
	}
	public OrderListDTO setOlCount(int olCount) {
		this.olCount = olCount;
		return this;
	}
	public Date getOlTime() {
		return olTime;
	}
	public int getOlOldCount() {
		return olOldCount;
	}
	public void setOlOldCount(int olOldCount) {
		this.olOldCount = olOldCount;
	}
	public OrderListDTO setOlTime(Date olTime) {
		this.olTime = olTime;
		return this;
	}
	public OrdersDTO getOrders() {
		return orders;
	}
	public OrderListDTO setOrders(OrdersDTO orders) {
		this.orders = orders;
		return this;
	}
	public FoodDTO getFood() {
		return food;
	}
	public OrderListDTO setFood(FoodDTO food) {
		this.food = food;
		return this;
	}
	public List<FoodDTO> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodDTO> foods) {
		this.foods = foods;
	}
	
}
