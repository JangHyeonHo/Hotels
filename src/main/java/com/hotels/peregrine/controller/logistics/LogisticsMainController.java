package com.hotels.peregrine.controller.logistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comp/logistics")
public class LogisticsMainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLogisticsMain() {
		return "logistics/main";
	}
}
