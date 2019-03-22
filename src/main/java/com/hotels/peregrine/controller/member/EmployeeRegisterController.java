package com.hotels.peregrine.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comp/member/singup")
public class EmployeeRegisterController {

	@RequestMapping(method = RequestMethod.GET)
	public String getform() {
		System.out.println("직원 등록 오픈");
		
		
		return"member/employeeRegister";
	}
}
