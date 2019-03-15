package com.hotels.peregrine.controller.logistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributorController {
	
	@RequestMapping(value="/comp/distributor/regist", method = RequestMethod.GET)
	public String regist() {
		
		return "logistics/distributor/distriRegist";
	}
	
}
