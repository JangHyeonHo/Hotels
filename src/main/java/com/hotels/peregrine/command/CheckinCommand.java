package com.hotels.peregrine.command;

import java.io.Serializable;

public class CheckinCommand implements Serializable{

	private int[] grStaySum;
	private int[] grNo;
	private int[] breakAdult;
	private int[] breakChild;
	private int[] DinAdult;
	private int[] DinChild;
	

	public int[] getGrStaySum() {
		return grStaySum;
	}
	public void setGrStaySum(int[] grStaySum) {
		this.grStaySum = grStaySum;
	}
	public int[] getGrNo() {
		return grNo;
	}
	public void setGrNo(int[] grNo) {
		this.grNo = grNo;
	}
	public int[] getBreakAdult() {
		return breakAdult;
	}
	public void setBreakAdult(int[] breakAdult) {
		this.breakAdult = breakAdult;
	}
	public int[] getBreakChild() {
		return breakChild;
	}
	public void setBreakChild(int[] breakChild) {
		this.breakChild = breakChild;
	}
	public int[] getDinAdult() {
		return DinAdult;
	}
	public void setDinAdult(int[] dinAdult) {
		DinAdult = dinAdult;
	}
	public int[] getDinChild() {
		return DinChild;
	}
	public void setDinChild(int[] dinChild) {
		DinChild = dinChild;
	}
	
	
	

	
}
