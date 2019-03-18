package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 사용 객실(guest_room) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★grNo</b> 객실 번호 <b>Primary Key</b><br>
 * <b>grDiAdult</b> 석식 성인 인원<br>
 * <b>grDiChild</b> 석식 어린이 인원<br>
 * <b>★grStaySum</b> 객실 숙박 인원<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★checkIn.cheNo</b> 수속(checkin)테이블 <b>Primary Key, Foreign Key</b><br>
 * @version 1.0
 * */
public class GuestRoomDTO implements Serializable {
	private int grNo;
	private int grDiAdult;
	private int grDiChild;
	private int grStaySum;
	private CheckInDTO checkIn;
	public int getGrNo() {
		return grNo;
	}
	public GuestRoomDTO setGrNo(int grNo) {
		this.grNo = grNo;
		return this;
	}
	public int getGrDiAdult() {
		return grDiAdult;
	}
	public GuestRoomDTO setGrDiAdult(int grDiAdult) {
		this.grDiAdult = grDiAdult;
		return this;
	}
	public int getGrDiChild() {
		return grDiChild;
	}
	public GuestRoomDTO setGrDiChild(int grDiChild) {
		this.grDiChild = grDiChild;
		return this;
	}
	public int getGrStaySum() {
		return grStaySum;
	}
	public GuestRoomDTO setGrStaySum(int grStaySum) {
		this.grStaySum = grStaySum;
		return this;
	}
	public CheckInDTO getCheckIn() {
		return checkIn;
	}
	public GuestRoomDTO setCheckIn(CheckInDTO checkIn) {
		this.checkIn = checkIn;
		return this;
	}
	
}
