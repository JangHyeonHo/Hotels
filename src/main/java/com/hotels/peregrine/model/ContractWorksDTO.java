package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 출근 계약(constract_works) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★cwNo</b> 계약 번호 <b>Primary Key</b><br>
 * <b>cwSWork</b> 직원 출근 시작 날짜<br>
 * <b>csEWork</b> 직원 출근 끝 날짜<br>
 * <b>cwOriOn</b> 해당 출근 시간<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★employee.empNo</b> 직원(employee)테이블 <b>Primary Key, Foreign Key</b><br>
 * @version 1.0
 * */
public class ContractWorksDTO implements Serializable {
	private int cwNo;
	private Date cwSWork;
	private Date csEWork;
	private Date cwOriOn;
	private EmployeeDTO employee;
	public int getCwNo() {
		return cwNo;
	}
	public ContractWorksDTO setCwNo(int cwNo) {
		this.cwNo = cwNo;
		return this;
	}
	public Date getCwSWork() {
		return cwSWork;
	}
	public ContractWorksDTO setCwSWork(Date cwSWork) {
		this.cwSWork = cwSWork;
		return this;
	}
	public Date getCsEWork() {
		return csEWork;
	}
	public ContractWorksDTO setCsEWork(Date csEWork) {
		this.csEWork = csEWork;
		return this;
	}
	public Date getCwOriOn() {
		return cwOriOn;
	}
	public ContractWorksDTO setCwOriOn(Date cwOriOn) {
		this.cwOriOn = cwOriOn;
		return this;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public ContractWorksDTO setEmployee(EmployeeDTO employee) {
		this.employee = employee;
		return this;
	}
	
}
