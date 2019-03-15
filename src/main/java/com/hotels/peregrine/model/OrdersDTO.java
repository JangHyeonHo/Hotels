package com.hotels.peregrine.model;
/**
 * 주문(orders) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★ordNo</b> 주문 번호 <b>Primary Key</b><br>
 * <b>ordTableNum</b> 테이블 번호<br>
 * <b>ordSumPrice</b> 음식 총 금액<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>payment.payNo</b> 결제(payment)테이블 <b>Foreign Key</b><br>
 * <b>restaurantReservation.rrNo<br>restaurantReservation.customer.cosNo</b> 레스토랑 예약(restaurant_reservation)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class OrdersDTO {
	private int ordNo;
	private int ordTableNum;
	private int ordSumPrice;
	private PaymentDTO payment;
	private RestaurantReservationDTO restaurantReservation;
	public int getOrdNo() {
		return ordNo;
	}
	public OrdersDTO setOrdNo(int ordNo) {
		this.ordNo = ordNo;
		return this;
	}
	public int getOrdTableNum() {
		return ordTableNum;
	}
	public OrdersDTO setOrdTableNum(int ordTableNum) {
		this.ordTableNum = ordTableNum;
		return this;
	}
	public int getOrdSumPrice() {
		return ordSumPrice;
	}
	public OrdersDTO setOrdSumPrice(int ordSumPrice) {
		this.ordSumPrice = ordSumPrice;
		return this;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public OrdersDTO setPayment(PaymentDTO payment) {
		this.payment = payment;
		return this;
	}
	public RestaurantReservationDTO getRestaurantReservation() {
		return restaurantReservation;
	}
	public OrdersDTO setRestaurantReservation(RestaurantReservationDTO restaurantReservation) {
		this.restaurantReservation = restaurantReservation;
		return this;
	}
	
}
