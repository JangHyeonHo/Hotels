package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 연회장 대여(banquet_rental) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★brNo</b> 연회장 대여 번호 <b>Primary Key</b><br>
 * <b>brOpen</b> 연회장 개최 시간<br>
 * <b>brClose</b> 연회장 폐회 시간<br>
 * <b>brConsumer</b> 연회장 이용 고객 수<br>
 * <b>brUseTime</b> 연회장 이용 날짜<br>
 * <b>brPurpose</b> 연회장 이용 목적<br>
 * <b>brPrice</b> 연회장 이용 금액<br>
 * <b>★brEating</b> 연회장 식사 여부<br>
 * <b>brExPay</b> 연회장 연장 추가 비용<br>
 * <b>★brRantalTime</b> 연회장 대여 시간<br>
 * <b>★brRegDate</b> 연회장 예약 등록일<br><p>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>banquet.banName</b> 연회장(banquet)테이블 <b>Foreign Key</b><br>
 * <b>payment.payNo</b> 결제(payment)테이블 <b>Foreign Key</b><br>
 * <b>customer.cosNo </b> 고객(customer)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class BanquetRentalDTO implements Serializable {
	private int brNo;
	private Date brOpen;
	private Date brClose;
	private int brConsumer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date brUseTime;
	private String brPurpose;
	private int brPrice;
	private String brEating;
	private int brExPay;
	private int brRantalTime;
	private Date brRegDate;
	private BanquetDTO banquet;
	private PaymentDTO payment;
	private CustomerDTO customer;
	
	
	public int getBrNo() {
		return brNo;
	}
	public BanquetRentalDTO setBrNo(int brNo) {
		this.brNo = brNo;
		return this;
	}
	public Date getBrOpen() {
		return brOpen;
	}
	public BanquetRentalDTO setBrOpen(Date brOpen) {
		this.brOpen = brOpen;
		return this;
	}
	public Date getBrClose() {
		return brClose;
	}
	public BanquetRentalDTO setBrClose(Date brClose) {
		this.brClose = brClose;
		return this;
	}
	public int getBrConsumer() {
		return brConsumer;
	}
	public BanquetRentalDTO setBrConsumer(int brConsumer) {
		this.brConsumer = brConsumer;
		return this;
	}
	public Date getBrUseTime() {
		return brUseTime;
	}
	public BanquetRentalDTO setBrUseTime(Date brUseTime) {
		this.brUseTime = brUseTime;
		return this;
	}
	public String getBrPurpose() {
		return brPurpose;
	}
	public BanquetRentalDTO setBrPurpose(String brPurpose) {
		this.brPurpose = brPurpose;
		return this;
	}
	public int getBrPrice() {
		return brPrice;
	}
	public BanquetRentalDTO setBrPrice(int brPrice) {
		this.brPrice = brPrice;
		return this;
	}
	public String getBrEating() {
		return brEating;
	}
	public BanquetRentalDTO setBrEating(String brEating) {
		this.brEating = brEating;
		return this;
	}
	public int getBrExPay() {
		return brExPay;
	}
	public BanquetRentalDTO setBrExPay(int brExPay) {
		this.brExPay = brExPay;
		return this;
	}
	public int getBrRantalTime() {
		return brRantalTime;
	}
	public BanquetRentalDTO setBrRantalTime(int brRantalTime) {
		this.brRantalTime = brRantalTime;
		return this;
	}
	public Date getBrRegDate() {
		return brRegDate;
	}
	public BanquetRentalDTO setBrRegDate(Date brRegDate) {
		this.brRegDate = brRegDate;
		return this;
	}
	public BanquetDTO getBanquet() {
		return banquet;
	}
	public BanquetRentalDTO setBanquet(BanquetDTO banquet) {
		this.banquet = banquet;
		return this;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public BanquetRentalDTO setPayment(PaymentDTO payment) {
		this.payment = payment;
		return this;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public BanquetRentalDTO setCustomer(CustomerDTO customer) {
		this.customer = customer;
		return this;
	}
	
}
