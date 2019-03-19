package com.hotels.peregrine.controller.banquet;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.service.banquet.BanquetDetailService;

@Controller

public class BanquetDetailController {
	
	@Autowired
	BanquetDetailService service;
	
	@RequestMapping(value="/comp/fb/banquet/list/detail", method=RequestMethod.GET)
	public String getform(@ModelAttribute("brNo") long num, Model model) {
		System.out.println("연회장 예약 디테일 오픈");
		
		BanquetRentalDTO dto = service.action(num);
		service.action(num);
		
		
		model.addAttribute("dto",dto);
		
	
		System.out.println(dto.getBrOpen());
		
		return "banquet/banquetDetail";
		
	}
	
	
	@RequestMapping(value="/comp/fb/banquet/list/detail/refreshone",method=RequestMethod.GET)
	public String getform1(@ModelAttribute("brNo") long num) {
		System.out.println("연회장 개최시간 수정");
			
		service.refreshOne(num);
				
			
		return "redirect:/comp/fb/banquet/list/detail?";
	}
	
	
	@RequestMapping(value="/comp/fb/banquet/list/detail/refreshtwo",method=RequestMethod.GET)
	public String getform2(@ModelAttribute("brNo") long num) {
		System.out.println("연회장 폐회시간 수정");
			
		service.refreshTwo(num);
		
		
		return "redirect:/comp/fb/banquet/list/detail?";
	}
	
	
	
	

}
