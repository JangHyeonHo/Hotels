package com.hotels.peregrine.command;

import java.io.Serializable;

public class RestaurantChairCommand implements Serializable {

	private String resName;
	private int resChair;
	private int resTableCount;
	
	
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public int getResChair() {
		return resChair;
	}
	public void setResChair(int resChair) {
		this.resChair = resChair;
	}
	public int getResTableCount() {
		return resTableCount;
	}
	public void setResTableCount(int resTableCount) {
		this.resTableCount = resTableCount;
	}
	
	
	

	
	
}
