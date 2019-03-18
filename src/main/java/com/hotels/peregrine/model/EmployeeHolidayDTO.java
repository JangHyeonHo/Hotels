package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 직원 휴일(employee_holiday) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★holiDate</b> 직원 휴가 날짜 <b>Primary Key</b><br>
 * <b>★holiContent</b> 휴가 내용<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★ContractWorks.cwNo<br>★ContractWorks.Employee.empNo</b> 직원 출근 계약(contract_works)테이블 <b>Primary Key, Foreign Key</b><br>
 * @version 1.0
 * */
public class EmployeeHolidayDTO implements Serializable {
	private Date holiDate;
	private String holiContent;
	private ContractWorksDTO contractWorks;
	public Date getHoliDate() {
		return holiDate;
	}
	public EmployeeHolidayDTO setHoliDate(Date holiDate) {
		this.holiDate = holiDate;
		return this;
	}
	public String getHoliContent() {
		return holiContent;
	}
	public EmployeeHolidayDTO setHoliContent(String holiContent) {
		this.holiContent = holiContent;
		return this;
	}
	public ContractWorksDTO getContractWorks() {
		return contractWorks;
	}
	public EmployeeHolidayDTO setContractWorks(ContractWorksDTO contractWorks) {
		this.contractWorks = contractWorks;
		return this;
	}
	
}
