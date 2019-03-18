package com.hotels.peregrine.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 스케줄(schedule) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★schDating</b> 해당 날짜 <b>Primary Key</b><br>
 * <b>schRealOn</b> 실제 출근 시간<br>
 * <b>schRealOff</b> 실제 퇴근 시간<br>
 * <b>schBreakTime</b> 휴식 시작 시간<br>
 * <b>schBtOff</b> 휴식 끝나는 시간<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★employee.empNo</b> 직원(employee)테이블 <b>Primary Key, Foreign Key</b><br>
 * @version 1.0
 * */
public class ScheduleDTO implements Serializable {
	private Date schDating;
	private Date schRealOn;
	private Date schRealOff;
	private Date schBreakTime;
	private Date schBtOff;
	private EmployeeDTO employee;
	public Date getSchDating() {
		return schDating;
	}
	public ScheduleDTO setSchDating(Date schDating) {
		this.schDating = schDating;
		return this;
	}
	public Date getSchRealOn() {
		return schRealOn;
	}
	public ScheduleDTO setSchRealOn(Date schRealOn) {
		this.schRealOn = schRealOn;
		return this;
	}
	public Date getSchRealOff() {
		return schRealOff;
	}
	public ScheduleDTO setSchRealOff(Date schRealOff) {
		this.schRealOff = schRealOff;
		return this;
	}
	public Date getSchBreakTime() {
		return schBreakTime;
	}
	public ScheduleDTO setSchBreakTime(Date schBreakTime) {
		this.schBreakTime = schBreakTime;
		return this;
	}
	public Date getSchBtOff() {
		return schBtOff;
	}
	public ScheduleDTO setSchBtOff(Date schBtOff) {
		this.schBtOff = schBtOff;
		return this;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public ScheduleDTO setEmployee(EmployeeDTO employee) {
		this.employee = employee;
		return this;
	}
	
}
