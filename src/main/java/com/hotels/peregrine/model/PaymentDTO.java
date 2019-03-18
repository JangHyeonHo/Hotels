package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 결제(payment) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★payNo</b> 결제 번호 <b>Primary Key</b><br>
 * <b>paySum</b> 결제 총 금액<br>
 * @version 1.0
 * */
public class PaymentDTO implements Serializable {
	private int payNo;
	private int paySum;
	public int getPayNo() {
		return payNo;
	}
	public PaymentDTO setPayNo(int payNo) {
		this.payNo = payNo;
		return this;
	}
	public int getPaySum() {
		return paySum;
	}
	public PaymentDTO setPaySum(int paySum) {
		this.paySum = paySum;
		return this;
	}
	
}
