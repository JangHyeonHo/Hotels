package com.hotels.peregrine.command;

import java.io.Serializable;

public class RestaurantCommand implements Serializable{

	private String resName;
	private String resTableCount;
	
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResTableCount() {
		return resTableCount;
	}
	public void setResTableCount(String resTableCount) {
		this.resTableCount = resTableCount;
	}

	
}
