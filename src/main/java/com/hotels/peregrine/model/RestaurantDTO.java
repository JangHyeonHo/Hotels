package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 레스토랑/라운지(restaurant) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★resName</b> 레스토랑 라운지 명 <b>Primary Key</b><br>
 * <b>★resChair</b> 레스토랑 라운지 의자 수 <b>Primary Key</b><br>
 * <b>resTableCount</b> 레스토랑 라운지 테이블 수<br>
 * <b>resDescription</b> 레스토랑 라운지 설명<br>
 * <b>resStoreFileName</b> 레스토랑 라운지 저장 사진<br>
 * @version 1.0
 * */
public class RestaurantDTO implements Serializable {
	private String resName;
	private int resChair;
	private int resTableCount;
	private String resDescription;
	private String resStoreFileName;
	public String getResName() {
		return resName;
	}
	public RestaurantDTO setResName(String resName) {
		this.resName = resName;
		return this;
	}
	public int getResChair() {
		return resChair;
	}
	public RestaurantDTO setResChair(int resChair) {
		this.resChair = resChair;
		return this;
	}
	public int getResTableCount() {
		return resTableCount;
	}
	public RestaurantDTO setResTableCount(int resTableCount) {
		this.resTableCount = resTableCount;
		return this;
	}
	public String getResDescription() {
		return resDescription;
	}
	public RestaurantDTO setResDescription(String resDescription) {
		this.resDescription = resDescription;
		return this;
	}
	public String getResStoreFileName() {
		return resStoreFileName;
	}
	public RestaurantDTO setResStoreFileName(String resStoreFileName) {
		this.resStoreFileName = resStoreFileName;
		return this;
	}
	
}
