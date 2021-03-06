package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 카드결제(card_pay) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>cpInsMonth</b> 할부개월<br>
 * <b>★cpCname</b> 결제 카드사명<br>
 * <b>★cpCnum</b> 결제 카드 번호<br>
 * <b>cpYear</b> 결제 유효기간 년<br>
 * <b>cpMonth</b> 결제 유효기간 월<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★payment.payNo</b> 결제(Payment) 테이블 <b>Primary Key, Foreign Key</b><br>
 * @version 1.8
 * */
public class CardPayDTO implements Serializable {
	private int cpInsMonth;
	private String cpCname;
	private String cpCnum;
	private int cpYear;
	private int cpMonth;
	private PaymentDTO payment;
	public int getCpInsMonth() {
		return cpInsMonth;
	}
	public CardPayDTO setCpInsMonth(int cpInsMonth) {
		this.cpInsMonth = cpInsMonth;
		return this;
	}
	public String getCpCname() {
		return cpCname;
	}
	public CardPayDTO setCpCname(String cpCname) {
		this.cpCname = cpCname;
		return this;
	}
	public String getCpCnum() {
		return cpCnum;
	}
	public CardPayDTO setCpCnum(String cpCnum) {
		this.cpCnum = cpCnum;
		return this;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public CardPayDTO setPayment(PaymentDTO payment) {
		this.payment = payment;
		return this;
	}
	public int getCpYear() {
		return cpYear;
	}
	public CardPayDTO setCpYear(int cpYear) {
		this.cpYear = cpYear;
		return this;
	}
	public int getCpMonth() {
		return cpMonth;
	}
	public CardPayDTO setCpMonth(int cpMonth) {
		this.cpMonth = cpMonth;
		return this;
	}
	
}
