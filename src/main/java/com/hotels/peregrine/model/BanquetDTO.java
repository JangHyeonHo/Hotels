package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 연회장(banquet) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★banName</b> 연회장 명 <b>Primary Key</b> <br>
 * <b>banPoundation</b> 연회장 기본금<br>
 * <b>banDescription</b> 연회장 설명<br>
 * <b>banTime</b> 연회장 기본 이용 시간<br>
 * <b>banMaxPeople</b> 연회장 최대 수용수<br>
 * <b>banStoreFileName</b> 연회장 저장 사진<br>
 * @version 1.01
 * */
public class BanquetDTO implements Serializable {
	private String banName;
	private int banPoundation;
	private String banDescription;
	private int banTime;
	private int banMaxPeople;
	private String banStoreFileName;
	public String getBanName() {
		return banName;
	}
	public BanquetDTO setBanName(String banName) {
		this.banName = banName;
		return this;
	}
	public int getBanPoundation() {
		return banPoundation;
	}
	public BanquetDTO setBanPoundation(int banPoundation) {
		this.banPoundation = banPoundation;
		return this;
	}
	public String getBanDescription() {
		return banDescription;
	}
	public BanquetDTO setBanDescription(String banDescription) {
		this.banDescription = banDescription;
		return this;
	}
	public int getBanTime() {
		return banTime;
	}
	public BanquetDTO setBanTime(int banTime) {
		this.banTime = banTime;
		return this;
	}
	public int getBanMaxPeople() {
		return banMaxPeople;
	}
	public BanquetDTO setBanMaxPeople(int banMaxPeople) {
		this.banMaxPeople = banMaxPeople;
		return this;
	}
	public String getBanStoreFileName() {
		return banStoreFileName;
	}
	public BanquetDTO setBanStoreFileName(String banStoreFileName) {
		this.banStoreFileName = banStoreFileName;
		return this;
	}
	
}
