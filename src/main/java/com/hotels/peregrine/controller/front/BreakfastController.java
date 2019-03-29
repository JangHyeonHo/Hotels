package com.hotels.peregrine.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BreakfastDTO;
import com.hotels.peregrine.service.front.BreakfastService;

@Controller
public class BreakfastController {
	
	@Autowired
	BreakfastService service;
	
	@RequestMapping(value = "/comp/front/breakfast", method = RequestMethod.GET)
	public String breakfast(Model model) {
		
		List<BreakfastDTO> list = service.action();
		model.addAttribute("list",list);

		
		return "front/brlist";
	}	

	 
}
