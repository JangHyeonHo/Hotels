package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 조식(breakfast) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★breakCoupon</b> 조식 쿠폰 번호 <b>Primary Key</b><br>
 * <b>breakKind</b> 조식 종류<br>
 * <b>breakAdult</b> 조식 성인 인원<br>
 * <b>breakChild</b> 조식 어린이 인원<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★guestRoom.grNo<br>★guestRoom.cheNo</b> 사용중인 객실(GuestRoom) 테이블 <b>Primary Key, Foreign Key</b><br>
 * @version 1.0
 * */
public class BreakfastDTO implements Serializable {
	private int breakCoupon;
	private String breakKind;
	private int breakAdult;
	private int breakChild;
	private GuestRoomDTO guestRoom;
	public int getBreakCoupon() {
		return breakCoupon;
	}
	public BreakfastDTO setBreakCoupon(int breakCoupon) {
		this.breakCoupon = breakCoupon;
		return this;
	}
	public String getBreakKind() {
		return breakKind;
	}
	public BreakfastDTO setBreakKind(String breakKind) {
		this.breakKind = breakKind;
		return this;
	}
	public int getBreakAdult() {
		return breakAdult;
	}
	public BreakfastDTO setBreakAdult(int breakAdult) {
		this.breakAdult = breakAdult;
		return this;
	}
	public int getBreakChild() {
		return breakChild;
	}
	public BreakfastDTO setBreakChild(int breakChild) {
		this.breakChild = breakChild;
		return this;
	}
	public GuestRoomDTO getGuestRoom() {
		return guestRoom;
	}
	public BreakfastDTO setGuestRoom(GuestRoomDTO guestRoom) {
		this.guestRoom = guestRoom;
		return this;
	}
}
