package com.hotels.peregrine.controller.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.service.banquet.BanquetDetailService;

@Controller
@RequestMapping("comp/fb/banquet/list/detail/refresh2")
public class BanquetCloseRefreshController {
	
	@Autowired
	BanquetDetailService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String Postform(@ModelAttribute("brNo") long num) {
		System.out.println("연회장 폐회시간 수정");
			
		service.refresh2(num);
		
		
		return "banquet/banquetDetail";
	}

}
