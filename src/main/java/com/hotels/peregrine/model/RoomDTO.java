package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 객실(room) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★roomName</b> 객실명 <b>Primary Key</b><br>
 * <b>roomPrice</b> 객실 이용금액<br>
 * <b>roomCount</b> 객실 수<br>
 * <b>roomStoreFileName</b> 객실 저장 사진<br>
 * @version 1.0
 * */
public class RoomDTO implements Serializable {
	private String roomName;
	private int roomPrice;
	private int roomCount;
	private String roomStoreFileName;
	public String getRoomName() {
		return roomName;
	}
	public RoomDTO setRoomName(String roomName) {
		this.roomName = roomName;
		return this;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public RoomDTO setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
		return this;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public RoomDTO setRoomCount(int roomCount) {
		this.roomCount = roomCount;
		return this;
	}
	public String getRoomStoreFileName() {
		return roomStoreFileName;
	}
	public RoomDTO setRoomStoreFileName(String roomStoreFileName) {
		this.roomStoreFileName = roomStoreFileName;
		return this;
	}
	
}
