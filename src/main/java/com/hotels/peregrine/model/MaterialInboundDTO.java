package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 자재 입고(material_in) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★miInbDate</b> 자재 입고일 <b>Primary Key</b><br>
 * <b>miPrice</b> 자재 가격<br>
 * <b>miInContent</b> 자재 입고 내용<br>
 * <b>★miInNum</b> 자재 입고 수<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★material.matNo</b> 자재(material)테이블 <b>Foreign Key</b><br>
 * @version 1.4
 * */
public class MaterialInboundDTO implements Serializable {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date miInbDate;
	private int miPrice;
	private String miInContent;
	private int miInNum;
	private MaterialDTO material;
	public Date getMiInbDate() {
		return miInbDate;
	}
	public MaterialInboundDTO setMiInbDate(Date miInbDate) {
		this.miInbDate = miInbDate;
		return this;
	}
	public int getMiPrice() {
		return miPrice;
	}
	public MaterialInboundDTO setMiPrice(int miPrice) {
		this.miPrice = miPrice;
		return this;
	}
	public String getMiInContent() {
		return miInContent;
	}
	public MaterialInboundDTO setMiInContent(String miInContent) {
		this.miInContent = miInContent;
		return this;
	}
	public int getMiInNum() {
		return miInNum;
	}
	public MaterialInboundDTO setMiInNum(int miInNum) {
		this.miInNum = miInNum;
		return this;
	}
	public MaterialDTO getMaterial() {
		return material;
	}
	public MaterialInboundDTO setMaterial(MaterialDTO material) {
		this.material = material;
		return this;
	}
	
}
