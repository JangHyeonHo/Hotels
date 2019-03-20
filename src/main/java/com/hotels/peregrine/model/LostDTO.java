package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 분실물(lost) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>lostNo</b> 분실 번호<br>
 * <b>lostName</b> 분실물 명<br>
 * <b>lostDate</b> 분실 날짜<br>
 * <b>lostLoc</b> 분실 위치<br>
 * @version 1.0
 * */
public class LostDTO implements Serializable {
	private int lostNo;
	private String lostName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lostDate;
	private String lostLoc;
	public int getLostNo() {
		return lostNo;
	}
	public LostDTO setLostNo(int lostNo) {
		this.lostNo = lostNo;
		return this;
	}
	public String getLostName() {
		return lostName;
	}
	public LostDTO setLostName(String lostName) {
		this.lostName = lostName;
		return this;
	}
	public Date getLostDate() {
		return lostDate;
	}
	public LostDTO setLostDate(Date lostDate) {
		this.lostDate = lostDate;
		return this;
	}
	public String getLostLoc() {
		return lostLoc;
	}
	public LostDTO setLostLoc(String lostLoc) {
		this.lostLoc = lostLoc;
		return this;
	}
	
}
