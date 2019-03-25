package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.service.front.breakfastDeleteService;

@Controller
public class BreakfastDeleteController {

	@Autowired
	breakfastDeleteService service;
	
	@RequestMapping(value = "/comp/front/breakfast/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("breakCoupon")int no, Model model) {
		service.action(no);
		return AutoAlertProcess.alertAfterRedirect(model, "조식정보 삭제", "삭제 되었습니다.", "../breakfast");
		
	}
}
