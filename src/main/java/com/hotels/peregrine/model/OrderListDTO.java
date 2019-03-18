package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 주문 리스트(order list) 테이블에 관한 것<br>
 * <p>
 * <b>변수</b><br>
 * <b>olCount</b> 주문 수량<br>
 * <b>olTime</b> 주문 시간<br>

 * <b>관계 테이블</b><br>
 * <b>orders</b> 주문(orders)테이블 <b>Primary Key, Foreign key</b><br>
 * <b>food</b> 음식(food)테이블 <b>Primary Key, Foreign key</b><br>
 * */
public class OrderListDTO implements Serializable {
	private int olCount;
	private Date olTime;
	private OrdersDTO orders;
	private FoodDTO food;
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
	public OrderListDTO setOlTime(Date olTime) {
		this.olTime = olTime;
		return this;
	}
	public OrdersDTO getOrder() {
		return orders;
	}
	public OrderListDTO setOrder(OrdersDTO orders) {
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
	
}
