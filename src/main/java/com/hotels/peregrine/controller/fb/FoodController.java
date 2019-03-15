package com.hotels.peregrine.controller.fb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {
	
	@RequestMapping(value="/comp/fb/restaurant/food/regist", method=RequestMethod.GET)
	public String foodRegistOpenController() {
		
		return "fb/food/foodRegist";
	}
	
}
