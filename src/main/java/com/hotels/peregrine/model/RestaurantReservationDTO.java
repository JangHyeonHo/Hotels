package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 레스토랑 예약(restaurant_reservation) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★rrNo</b> 예약 번호 <b>Primary Key</b><br>
 * <b>rrAdult</b> 레스토랑 고객 성인 인원수<br>
 * <b>rrChild</b> 레스토랑 고객 어린이 인원수<br>
 * <b>rrRegDate</b> 예약 등록일<br>
 * <b>rrDate</b> 예약날짜<br>
 * <b>ordTableNum</b> 테이블번호(orders)<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★customer.cosNo</b> 고객(customer)테이블 <b>Primary Key, Foreign Key</b><br>
 * <b>restaurant.res_name<br>restaurant.res_chair</b> 레스토랑/라운지(restaurant)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class RestaurantReservationDTO implements Serializable {
	private int rrNo;
	private int rrAdult;
	private int rrChild;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date rrDate;
	private Date rrRegDate;
	private int ordTableNum;
	private CustomerDTO customer;
	private RestaurantDTO restaurant;
	public int getRrNo() {
		return rrNo;
	}
	public RestaurantReservationDTO setRrNo(int rrNo) {
		this.rrNo = rrNo;
		return this;
	}
	public int getRrAdult() {
		return rrAdult;
	}
	public RestaurantReservationDTO setRrAdult(int rrAdult) {
		this.rrAdult = rrAdult;
		return this;
	}
	public int getRrChild() {
		return rrChild;
	}
	public RestaurantReservationDTO setRrChild(int rrChild) {
		this.rrChild = rrChild;
		return this;
	}
	public int getOrdTableNum() {
		return ordTableNum;
	}
	public RestaurantReservationDTO setOrdTableNum(int ordTableNum) {
		this.ordTableNum = ordTableNum;
		return this;
	}
	public Date getRrDate() {
		return rrDate;
	}
	
	public RestaurantReservationDTO setRrDate(Date rrDate) {
		this.rrDate = rrDate;
		return this;
	}
	public Date getRrRegDate() {
		return rrRegDate;
	}
	public RestaurantReservationDTO setRrRegDate(Date rrRegDate) {
		this.rrRegDate = rrRegDate;
		return this;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public RestaurantReservationDTO setCustomer(CustomerDTO customer) {
		this.customer = customer;
		return this;
	}
	public RestaurantDTO getRestaurant() {
		return restaurant;
	}
	public RestaurantReservationDTO setRestaurant(RestaurantDTO restaurant) {
		this.restaurant = restaurant;
		return this;
	}
	
}
