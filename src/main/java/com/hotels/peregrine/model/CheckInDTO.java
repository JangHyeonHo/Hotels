package com.hotels.peregrine.model;

import java.util.Date;

/**
 * 수속(checkin) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★cheNo</b> 수속번호 <b>Primary Key</b><br>
 * <b>★cheInTime</b> 객실 체크인 시간<br>
 * <b>★cheOutTime</b> 객실 체크아웃 시간<br>
 * <b>★cheInDate</b> 입실 예정일<br>
 * <b>★cheOutDate</b> 퇴실 예정일<br>
 * <b>cheDetail</b> 객실 선호 사항<br>
 * <b>★cheRegDate</b> 객실 예약 등록일<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★customer.cosNo</b> 고객(customer)테이블 <b>Foreign Key</b><br>
 * <b>★payment.payNo</b> 결제(payment)테이블 <b>Foreign Key</b><br>
 * <b>★room.roomName</b> 객실(room)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class CheckInDTO {
	
	private int cheNo;
	private Date cheInTime;
	private Date cheOutTime;
	private Date cheInDate;
	private Date cheOutDate;
	private String cheDetail;
	private Date cheRegDate;
	private CustomerDTO customer;
	private PaymentDTO payment;
	private RoomDTO room;
	public int getCheNo() {
		return cheNo;
	}
	public CheckInDTO setCheNo(int cheNo) {
		this.cheNo = cheNo;
		return this;
	}
	public Date getCheInTime() {
		return cheInTime;
	}
	public CheckInDTO setCheInTime(Date cheInTime) {
		this.cheInTime = cheInTime;
		return this;
	}
	public Date getCheOutTime() {
		return cheOutTime;
	}
	public CheckInDTO setCheOutTime(Date cheOutTime) {
		this.cheOutTime = cheOutTime;
		return this;
	}
	public Date getCheInDate() {
		return cheInDate;
	}
	public CheckInDTO setCheInDate(Date cheInDate) {
		this.cheInDate = cheInDate;
		return this;
	}
	public Date getCheOutDate() {
		return cheOutDate;
	}
	public CheckInDTO setCheOutDate(Date cheOutDate) {
		this.cheOutDate = cheOutDate;
		return this;
	}
	public String getCheDetail() {
		return cheDetail;
	}
	public CheckInDTO setCheDetail(String cheDetail) {
		this.cheDetail = cheDetail;
		return this;
	}
	public Date getCheRegDate() {
		return cheRegDate;
	}
	public CheckInDTO setCheRegDate(Date cheRegDate) {
		this.cheRegDate = cheRegDate;
		return this;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public CheckInDTO setCustomer(CustomerDTO customer) {
		this.customer = customer;
		return this;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public CheckInDTO setPayment(PaymentDTO payment) {
		this.payment = payment;
		return this;
	}
	public RoomDTO getRoom() {
		return room;
	}
	public CheckInDTO setRoom(RoomDTO room) {
		this.room = room;
		return this;
	}
	
}
