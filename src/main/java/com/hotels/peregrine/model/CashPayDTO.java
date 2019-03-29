package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 현금결제(cash_pay) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>cashReceipt</b> 현금영수증 전화 번호<br>
 * <b>cashCeoReceipt</b> 현금영수증 사업자번호<br>
 * <b>관계 테이블</b><br>
 * <b>★payment.payNo</b> 결제(Payment) 테이블<b>Primary Key, Foreign Key</b><br>
 * @version 1.0
 * */
public class CashPayDTO implements Serializable {
	private String cashReceipt;
	private String cashCeoReceipt;
	private PaymentDTO payment;
	public String getCashReceipt() {
		return cashReceipt;
	}
	public CashPayDTO setCashReceipt(String cashReceipt) {
		this.cashReceipt = cashReceipt;
		return this;
	}
	public String getCashCeoReceipt() {
		return cashCeoReceipt;
	}
	public CashPayDTO setCashCeoReceipt(String cashCeoReceipt) {
		this.cashCeoReceipt = cashCeoReceipt;
		return this;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public CashPayDTO setPayment(PaymentDTO payment) {
		this.payment = payment;
		return this;
	}
}
