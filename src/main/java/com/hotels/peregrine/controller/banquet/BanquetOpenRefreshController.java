package com.hotels.peregrine.controller.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.service.banquet.BanquetDetailService;

@Controller
@RequestMapping("comp/fb/banquet/list/detail/refresh1")
public class BanquetOpenRefreshController {
	
	@Autowired
	BanquetDetailService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String Postform(@ModelAttribute("brNo") long num) {
		System.out.println("연회장 개최시간 수정");
			
		service.refresh(num);
		
		
		return "banquet/banquetDetail";
	}

}
