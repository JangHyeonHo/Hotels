package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 결제(payment) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★payNo</b> 결제 번호 <b>Primary Key</b><br>
 * <b>paySum</b> 결제 총 금액<br>
 * <b>★payDate</b> 결제월<br>
 * @version 1.0
 * */
public class PaymentDTO implements Serializable {
	private int payNo;
	private int paySum;
	@DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
	private Date payDate;
	
	
	public Date getPayDate() {
		return payDate;
	}
	public PaymentDTO setPayDate(Date payDate) {
		this.payDate = payDate;
		return this;
	}
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
