package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 자재 대여(tool_rental) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★trNo</b> 도구 대여 번호 <b>Primary Key</b><br>
 * <b>trPrice</b> 연회장 도구 대여비<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★banquetRental.brNo</b> 연회장 대여(banquet_rental)테이블 <b>Primary Key, Foreign Key</b><br>
 * <b>material.matNo</b> 자재(material)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class ToolRentalDTO implements Serializable {
	private int trNo;
	private int trPrice;
	private BanquetRentalDTO banquetRental;
	private MaterialDTO material;
	public int getTrNo() {
		return trNo;
	}
	public ToolRentalDTO setTrNo(int trNo) {
		this.trNo = trNo;
		return this;
	}
	public int getTrPrice() {
		return trPrice;
	}
	public ToolRentalDTO setTrPrice(int trPrice) {
		this.trPrice = trPrice;
		return this;
	}
	public BanquetRentalDTO getBanquetRental() {
		return banquetRental;
	}
	public ToolRentalDTO setBanquetRental(BanquetRentalDTO banquetRental) {
		this.banquetRental = banquetRental;
		return this;
	}
	public MaterialDTO getMaterial() {
		return material;
	}
	public ToolRentalDTO setMaterial(MaterialDTO material) {
		this.material = material;
		return this;
	}
	
}
