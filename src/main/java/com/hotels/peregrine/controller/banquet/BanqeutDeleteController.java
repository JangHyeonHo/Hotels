package com.hotels.peregrine.controller.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.service.banquet.BanquetDeleteService;

@Controller
@RequestMapping("/comp/fb/banquet/list/detail/delete")
public class BanqeutDeleteController {

	@Autowired
	BanquetDeleteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getform(@ModelAttribute("brNo") long num) {
		System.out.println("연회장 예약 삭제 오픈");
	service.action(num);	
		
		return "redirect:/comp/fb/banquet/list";
	}
	
	
}
