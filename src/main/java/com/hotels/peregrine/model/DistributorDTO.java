package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 유통업체(distributor) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★disNo</b> 사업장 등록 번호 <b>Primary Key</b><br>
 * <b>★disName</b> 사업장명<br>
 * <b>★disPhone</b> 사업장 전화번호<br>
 * <b>disAddr</b> 사업장 구 주소<br>
 * <b>disZipCode</b> 사업장 구 우편번호<br>
 * <b>disNAddr</b> 사업장 신 주소<br>
 * <b>disNZipCode</b> 사업장 신 우편번호<br>
 * <b>disRegDate</b> 사업장 허가일자<br>
 * @version 1.01
 * */
public class DistributorDTO implements Serializable {
	private int disNo;
	private String disName;
	private String disPhone;
	private String disAddr;
	private int disZipCode;
	private String disNAddr;
	private int disNZipCode;
	private Date disRegDate;
	
	public int getDisNo() {
		return disNo;
	}
	public void setDisNo(int disNo) {
		this.disNo = disNo;
	}
	public String getDisName() {
		return disName;
	}
	public DistributorDTO setDisName(String disName) {
		this.disName = disName;
		return this;
	}
	public String getDisPhone() {
		return disPhone;
	}
	public DistributorDTO setDisPhone(String disPhone) {
		this.disPhone = disPhone;
		return this;
	}
	public String getDisAddr() {
		return disAddr;
	}
	public DistributorDTO setDisAddr(String disAddr) {
		this.disAddr = disAddr;
		return this;
	}
	public int getDisZipCode() {
		return disZipCode;
	}
	public DistributorDTO setDisZipCode(int disZipCode) {
		this.disZipCode = disZipCode;
		return this;
	}
	public String getDisNAddr() {
		return disNAddr;
	}
	public DistributorDTO setDisNAddr(String disNAddr) {
		this.disNAddr = disNAddr;
		return this;
	}
	public int getDisNZipCode() {
		return disNZipCode;
	}
	public DistributorDTO setDisNZipCode(int disNZipCode) {
		this.disNZipCode = disNZipCode;
		return this;
	}
	public Date getDisRegDate() {
		return disRegDate;
	}
	public DistributorDTO setDisRegDate(Date disRegDate) {
		this.disRegDate = disRegDate;
		return this;
	}
	
}
