package com.hotels.peregrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comp")
public class BackMainController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getform() {
		System.out.println("뒷메인 오픈");
		
		return"backMain";
	}
}
