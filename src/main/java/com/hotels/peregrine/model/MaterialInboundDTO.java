package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 자재 입고(material_in) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★miInbDate</b> 자재 입고일 <b>Primary Key</b><br>
 * <b>miPrice</b> 자재 가격<br>
 * <b>miInContent</b> 자재 입고 내용<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★material.matNo</b> 자재(material)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class MaterialInboundDTO implements Serializable {
	private Date miInbDate;
	private int miPrice;
	private int miInContent;
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
	public int getMiInContent() {
		return miInContent;
	}
	public MaterialInboundDTO setMiInContent(int miInContent) {
		this.miInContent = miInContent;
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
