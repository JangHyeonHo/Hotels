package com.hotels.peregrine.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BreakfastDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.front.CheckOutListService;

@Controller
public class CheckOutListController {

	@Autowired
	private CheckOutListService service;
	
	@RequestMapping(value = "/comp/front/checkout", method = RequestMethod.GET)
	public String checkOutList(Model model) {
		
		List<BreakfastDTO> list = service.action();
		model.addAttribute("list",list);
		System.out.println("무엇?몇줄?:"+list.size());
		AutoTest.ModelBlackTest(list.get(0));
	
		return "front/checkoutlist";
	}	
}
