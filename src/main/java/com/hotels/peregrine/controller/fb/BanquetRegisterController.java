package com.hotels.peregrine.controller.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.service.fb.BanquetRegisterService;

@Controller
@RequestMapping("/comp/fb/banquet/register")
public class BanquetRegisterController {
	
	@Autowired
	BanquetRegisterService service ;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getform() {
		System.out.println("연회장 등록 오픈");
		return "banquet/banquetRegister";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postform(@ModelAttribute BanquetDTO dto) {
		AutoTest.ModelBlackTest(dto);
		System.out.println("연회장 등록 포스트 오픈");
		service.action(dto);
		
		
		
		return "...";
	}
}
