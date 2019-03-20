package com.hotels.peregrine.controller.lost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LostMainController {

	
	
	@RequestMapping(value = "/comp/lost", method = RequestMethod.GET)
	public String main() {
		

		return "lost/main";
	}
}
