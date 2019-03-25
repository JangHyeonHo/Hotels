package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BreakfastDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.front.BreakfastDetailService;

@Controller
public class BreakfastDetailController {
	
	@Autowired
	BreakfastDetailService service ;
	
	
	@RequestMapping(value = "/comp/front/breakfast/detail", method = RequestMethod.GET)
	public String roominfo(@ModelAttribute("grNo")int no, Model model) {
		
		BreakfastDTO bf = service.action(no);
		model.addAttribute("bf", bf);
		
		return "front/breakfastDetail";
	}
	
	@RequestMapping(value = "/comp/front/breakfast/detail", method = RequestMethod.POST)
	public String roominfo(@ModelAttribute BreakfastDTO bf , Model model) {
		AutoTest.ModelBlackTest(bf);
		service.create(bf);
		return AutoAlertProcess.alertAfterRedirect(model, "등록완료", "등록되었습니다.", "../breakfast");
	}
	
}
