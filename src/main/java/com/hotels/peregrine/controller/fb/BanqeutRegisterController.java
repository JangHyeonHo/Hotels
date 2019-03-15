package com.hotels.peregrine.controller.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.service.fb.BanqeutRegisterService;

@Controller
@RequestMapping("/fb/bregister")
public class BanqeutRegisterController {
	
	@Autowired
	BanqeutRegisterService service ;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getform() {
		System.out.println("연회장 등록 오픈");
		return "banquet/banquetRegister";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postform() {
		
		System.out.println("연회장 등록 포스트 오픈");
		service.action();
		
		
		
		return "...";
	}
}
