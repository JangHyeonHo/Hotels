package com.hotels.peregrine.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.EmployeeDTO;
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
	public String postform(@ModelAttribute EmployeeDTO dto) {
		System.out.println("직원 등록 포스트 작동");
		AutoTest.ModelBlackTest(dto);
		service.action(dto);
		
		return "redirect:list";
	}
}
