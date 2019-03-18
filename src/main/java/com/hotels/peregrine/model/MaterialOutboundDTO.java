package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 자재 출고(material_out) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★moOutbDate</b> 자재 출고일시 <b>Primary Key</b><br>
 * <b>★moOutNum</b> 자재 출고수<br>
 * <b>moOutContent</b> 자재 출고 내용<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★material.matNo</b> 자재(material)테이블 <b>Foreign Key</b><br>
 * <b>★employee.empNo</b> 직원(employee)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class MaterialOutboundDTO implements Serializable {
	private Date moOutbDate;
	private int moOutNum;
	private String moOutContent;
	private MaterialDTO material;
	private EmployeeDTO employee;
	public Date getMoOutbDate() {
		return moOutbDate;
	}
	public MaterialOutboundDTO setMoOutbDate(Date moOutbDate) {
		this.moOutbDate = moOutbDate;
		return this;
	}
	public int getMoOutNum() {
		return moOutNum;
	}
	public MaterialOutboundDTO setMoOutNum(int moOutNum) {
		this.moOutNum = moOutNum;
		return this;
	}
	public String getMoOutContent() {
		return moOutContent;
	}
	public MaterialOutboundDTO setMoOutContent(String moOutContent) {
		this.moOutContent = moOutContent;
		return this;
	}
	public MaterialDTO getMaterial() {
		return material;
	}
	public MaterialOutboundDTO setMaterial(MaterialDTO material) {
		this.material = material;
		return this;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public MaterialOutboundDTO setEmployee(EmployeeDTO employee) {
		this.employee = employee;
		return this;
	}
	
}
