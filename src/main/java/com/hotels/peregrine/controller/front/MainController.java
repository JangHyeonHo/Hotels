package com.hotels.peregrine.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/comp/front", method = RequestMethod.GET)
	public String main() {
		

		
		return "front/main";
	}
}
