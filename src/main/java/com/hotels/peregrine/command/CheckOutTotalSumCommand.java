package com.hotels.peregrine.command;

public class CheckOutTotalSumCommand {
	private int cheNo;
	private int roomPrice;
	private int diAdult;
	private int diChild;
	private int breakAdult;
	private int breakChild;
	private int totalPrice;
	public int getCheNo() {
		return cheNo;
	}
	public CheckOutTotalSumCommand setCheNo(int cheNo) {
		this.cheNo = cheNo;
		return this;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public CheckOutTotalSumCommand setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
		return this;
	}
	public int getDiAdult() {
		return diAdult;
	}
	public CheckOutTotalSumCommand setDiAdult(int diAdult) {
		this.diAdult = diAdult;
		return this;
	}
	public int getDiChild() {
		return diChild;
	}
	public CheckOutTotalSumCommand setDiChild(int diChild) {
		this.diChild = diChild;
		return this;
	}
	public int getBreakAdult() {
		return breakAdult;
	}
	public CheckOutTotalSumCommand setBreakAdult(int breakAdult) {
		this.breakAdult = breakAdult;
		return this;
	}
	public int getBreakChild() {
		return breakChild;
	}
	public CheckOutTotalSumCommand setBreakChild(int breakChild) {
		this.breakChild = breakChild;
		return this;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public CheckOutTotalSumCommand setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}
	
	
}
