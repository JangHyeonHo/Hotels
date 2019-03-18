package com.hotels.peregrine.controller.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.service.banquet.BanquetDetailService;

@Controller
@RequestMapping("comp/fb/banquet/list/detail")
public class BanquetDetailController {
	
	@Autowired
	BanquetDetailService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getform(@ModelAttribute("brNo") long num, Model model) {
		System.out.println("연회장 예약 디테일 오픈");
		
		BanquetRentalDTO dto = service.action(num);
		service.refresh(num);
		
		model.addAttribute("dto",dto);
		
		return "banquet/banquetDetail";
	}
	
	
	
	

}
