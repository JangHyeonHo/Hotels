package com.hotels.peregrine.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.EmployeeDTO;
import com.hotels.peregrine.service.Employee.EmployeeListService;

@Controller
public class EmployeeListController {

	@Autowired
	EmployeeListService sercive;
	
	@RequestMapping(value="/comp/fb/member/list" , method = RequestMethod.GET)
	public String getForm(Model model) {
		System.out.println("직원 리스트 오픈");
		
		List<EmployeeDTO> list = sercive.action();
		model.addAttribute("list",list);
		
		return "member/employeelist";
	}
	
}
