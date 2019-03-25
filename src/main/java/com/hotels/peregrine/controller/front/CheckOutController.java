package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.service.front.CheckOutService;

@Controller
public class CheckOutController {

	@Autowired
	CheckOutService service;
	
	@RequestMapping(value = "/comp/front/rooms/checkout", method = RequestMethod.GET)
	public String checkout(@ModelAttribute("checkout")int num, Model model) {
		
		
		
		return "";
		
	}
}
