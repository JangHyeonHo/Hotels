package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.front.CheckinService;

@Controller
public class CheckinController {

	@Autowired
	CheckinService service;
	

	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/comp/front/checkin", method = RequestMethod.GET)
	public String checkin() {
		
		
		
		return "front/checkin";
	}	
	
	
	@RequestMapping(value = "/comp/front/checkin", method = RequestMethod.POST)
	public String checkin(@ModelAttribute CheckInDTO check, CustomerDTO customer, Model model) {
		System.out.println("체크인 post");
		AutoTest.ModelBlackTest(check);
		AutoTest.ModelBlackTest(customer);
		service.action(check);
		
		return AutoAlertProcess.alertAfterRedirect(model, "체크인 완료", "체크인 되었습니다.", "../front");
	}	
}
