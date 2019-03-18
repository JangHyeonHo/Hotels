package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 고객(customer) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★cosNo</b> 고객 번호 <b>Primary Key</b><br>
 * <b>★cosTelno</b> 고객 전화번호<br>
 * <b>★cosLName</b> 고객 성<br>
 * <b>★cosFName</b> 고객 이메일 주소<br>
 * <b>cosEmail</b> 고객 이름<br>
 * <b>cosAllergy</b> 고객 알러지 유무<br>
 * @version 1.0
 * */
public class CustomerDTO implements Serializable {
	private int cosNo;
	private String cosTelno;
	private String cosLName;
	private String cosFName;
	private String cosEmail;
	private String cosAllergy;
	public int getCosNo() {
		return cosNo;
	}
	public CustomerDTO setCosNo(int cosNo) {
		this.cosNo = cosNo;
		return this;
	}
	public String getCosTelno() {
		return cosTelno;
	}
	public CustomerDTO setCosTelno(String cosTelno) {
		this.cosTelno = cosTelno;
		return this;
	}
	public String getCosLName() {
		return cosLName;
	}
	public CustomerDTO setCosLName(String cosLName) {
		this.cosLName = cosLName;
		return this;
	}
	public String getCosFName() {
		return cosFName;
	}
	public CustomerDTO setCosFName(String cosFName) {
		this.cosFName = cosFName;
		return this;
	}
	public String getCosEmail() {
		return cosEmail;
	}
	public CustomerDTO setCosEmail(String cosEmail) {
		this.cosEmail = cosEmail;
		return this;
	}
	public String getCosAllergy() {
		return cosAllergy;
	}
	public CustomerDTO setCosAllergy(String cosAllergy) {
		this.cosAllergy = cosAllergy;
		return this;
	}
	
	
}
