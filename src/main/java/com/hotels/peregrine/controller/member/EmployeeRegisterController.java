package com.hotels.peregrine.controller.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.EmployeeDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.Employee.EmployeeRegisterService;

@Controller

public class EmployeeRegisterController {

	@Autowired
	EmployeeRegisterService service;
	
	@RequestMapping(value = "/comp/member/signup" , method = RequestMethod.GET)
	public String getform() {
		System.out.println("직원 등록 오픈");
		
		
		return"member/employeeRegister";
	}
	
	@RequestMapping(value = "/comp/member/signup", method = RequestMethod.POST)
	public String postform(@ModelAttribute EmployeeDTO dto, Model model) {
		System.out.println("직원 등록 포스트 작동");
		Date today = new Date();
		String empNo = ""+new SimpleDateFormat("YYMMddHHmm").format(today);
		System.out.println(empNo);
		dto.setEmpNo(empNo);
		AutoTest.ModelBlackTest(dto);
		service.action(dto);
		
		return AutoAlertProcess.alertAfterRedirect(model, "등록완료", "성공적으로 등록되었습니다\\n회원번호는 : "+empNo+" 입니다.", "./login");
	}
}
