package com.hotels.peregrine.command;

import java.io.Serializable;

public class CheckinCommend implements Serializable{

	private String[] grStaySum;
	private String[] grNo;

	
	
	
	public String[] getGrNo() {
		return grNo;
	}

	public void setGrNo(String[] grNo) {
		this.grNo = grNo;
	}

	public String[] getGrStaySum() {
		return grStaySum;
	}

	public void setGrStaySum(String[] grStaySum) {
		this.grStaySum = grStaySum;
	}
	
	
}
