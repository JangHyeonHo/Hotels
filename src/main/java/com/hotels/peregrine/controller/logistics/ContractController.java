package com.hotels.peregrine.controller.logistics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContractController {
	
	@RequestMapping(value="/comp/contract", method = RequestMethod.GET)
	public String regist(Model model) {
		
		return "logistics/contract/distriRegist";
	}
}
