package com.hotels.peregrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class CusPageMainController {

	@RequestMapping(method=RequestMethod.GET)
	public String getform() {
		System.out.println("고객 페이지오픈");
		
		
		return	"cusPageMain";
	}
}
