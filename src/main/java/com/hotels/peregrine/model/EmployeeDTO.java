package com.hotels.peregrine.model;

import java.util.Date;

/**
 * 
 * 직원(employee) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★empNo</b> 직원 번호 <b>Primary Key</b><br>
 * <b>★empName</b> 직원 전화번호<br>
 * <b>★empEmail</b> 직원 이메일<br>
 * <b>★empPhone</b> 직원 이름<br>
 * <b>★empBDate</b> 직원 생년 월일<br>
 * <b>★empGender</b> 직원 성별<br>
 * <b>★empSalary</b> 직원 급여<br>
 * <b>★empAddr</b> 직원 주소<br>
 * <b>empAccNum</b> 직원 통장 계좌번호<br>
 * <b>empAccBank</b> 직원 통장 은행명<br>
 * <b>empTopSize</b> 직원 옷 상의 치수<br>
 * <b>empBotSize</b> 직원 옷 하의 치수<br>
 * <b>★empManageName</b> 직원 직급명<br>
 * <b>★empDepartName</b> 직원 부서명<br>
 * @version 1.0
 * */
public class EmployeeDTO {
	private String empNo;
	private String empName;
	private String empEmail;
	private String empPhone;
	private Date empBDate;
	private String empGender;
	private int empSalary;
	private String empAddr;
	private String empAccNum;
	private String empAccBank;
	private int empTopSize;
	private int empBotSize;
	private String empManageName;
	private String empDepartName;
	public String getEmpNo() {
		return empNo;
	}
	public EmployeeDTO setEmpNo(String empNo) {
		this.empNo = empNo;
		return this;
	}
	public String getEmpName() {
		return empName;
	}
	public EmployeeDTO setEmpName(String empName) {
		this.empName = empName;
		return this;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public EmployeeDTO setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
		return this;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public EmployeeDTO setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
		return this;
	}
	public Date getEmpBDate() {
		return empBDate;
	}
	public EmployeeDTO setEmpBDate(Date empBDate) {
		this.empBDate = empBDate;
		return this;
	}
	public String getEmpGender() {
		return empGender;
	}
	public EmployeeDTO setEmpGender(String empGender) {
		this.empGender = empGender;
		return this;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public EmployeeDTO setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
		return this;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public EmployeeDTO setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
		return this;
	}
	public String getEmpAccNum() {
		return empAccNum;
	}
	public EmployeeDTO setEmpAccNum(String empAccNum) {
		this.empAccNum = empAccNum;
		return this;
	}
	public String getEmpAccBank() {
		return empAccBank;
	}
	public EmployeeDTO setEmpAccBank(String empAccBank) {
		this.empAccBank = empAccBank;
		return this;
	}
	public int getEmpTopSize() {
		return empTopSize;
	}
	public EmployeeDTO setEmpTopSize(int empTopSize) {
		this.empTopSize = empTopSize;
		return this;
	}
	public int getEmpBotSize() {
		return empBotSize;
	}
	public EmployeeDTO setEmpBotSize(int empBotSize) {
		this.empBotSize = empBotSize;
		return this;
	}
	public String getEmpManageName() {
		return empManageName;
	}
	public EmployeeDTO setEmpManageName(String empManageName) {
		this.empManageName = empManageName;
		return this;
	}
	public String getEmpDepartName() {
		return empDepartName;
	}
	public EmployeeDTO setEmpDepartName(String empDepartName) {
		this.empDepartName = empDepartName;
		return this;
	}
	
	
}
