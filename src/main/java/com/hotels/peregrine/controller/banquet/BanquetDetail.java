package com.hotels.peregrine.controller.banquet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("comp/fb/banquet/list/detail")
public class BanquetDetail {
	
	public String getform(@ModelAttribute("brNo") String num) {
		System.out.println("연회장 예약 디테일 오픈");
		
		
		return "banquet/banquetDetail";
	}

}
