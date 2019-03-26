package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.front.CheckOutService;

@Controller
public class CheckOutController {

	@Autowired
	CheckOutService service;
	
	@RequestMapping(value = "/comp/front/rooms/checkout", method = RequestMethod.GET)
	public String checkout(@ModelAttribute("cheNo")int num, Model model) {
		
		service.checkout(num);
		
		return AutoAlertProcess.alertAfterRedirect(model, "체크아웃", "체크아웃 되었습니다.", "../rooms");
		
	}
}
 