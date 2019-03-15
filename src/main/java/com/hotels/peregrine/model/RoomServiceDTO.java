package com.hotels.peregrine.model;
/**
 * 룸 서비스(r_service) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★rserNo</b> 룸 서비스 요청 번호 <b>Primary Key</b><br>
 * <b>rserDepart</b> 룸 서비스 처리부서<br>
 * <b>rserContents</b> 룸 서비스 내용<br>
 * <b>rserProcessing</b> 룸 서비스 처리 여부<br>
 * <b>rserPrice</b> 룸 서비스 처리 비용<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★checkin.cheNo</b> 수속(checkin)테이블 <b>Foreign Key</b><br>
 * <b>employee.empNo</b> 직원(employee)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class RoomServiceDTO {
	private int rserNo;
	private String rserDepart;
	private String rserContents;
	private String rserProcessing;
	private String rserPrice;
	private CheckInDTO checkin;
	private EmployeeDTO employee;
	public int getRserNo() {
		return rserNo;
	}
	public RoomServiceDTO setRserNo(int rserNo) {
		this.rserNo = rserNo;
		return this;
	}
	public String getRserDepart() {
		return rserDepart;
	}
	public RoomServiceDTO setRserDepart(String rserDepart) {
		this.rserDepart = rserDepart;
		return this;
	}
	public String getRserContents() {
		return rserContents;
	}
	public RoomServiceDTO setRserContents(String rserContents) {
		this.rserContents = rserContents;
		return this;
	}
	public String getRserProcessing() {
		return rserProcessing;
	}
	public RoomServiceDTO setRserProcessing(String rserProcessing) {
		this.rserProcessing = rserProcessing;
		return this;
	}
	public String getRserPrice() {
		return rserPrice;
	}
	public RoomServiceDTO setRserPrice(String rserPrice) {
		this.rserPrice = rserPrice;
		return this;
	}
	public CheckInDTO getCheckin() {
		return checkin;
	}
	public RoomServiceDTO setCheckin(CheckInDTO checkin) {
		this.checkin = checkin;
		return this;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public RoomServiceDTO setEmployee(EmployeeDTO employee) {
		this.employee = employee;
		return this;
	}
	
}
