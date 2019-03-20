package com.hotels.peregrine.controller.lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.LostDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.lost.CreateService;

@Controller
public class LostCreateController {

	@Autowired
	CreateService service;
	
	@RequestMapping(value = "/comp/lost/create", method = RequestMethod.GET)
	public String create() {
	
		return "lost/create";
	}
	
	
	@RequestMapping(value = "/comp/lost/create", method = RequestMethod.POST)
	public String create(@ModelAttribute LostDTO lost, Model model) {
		AutoTest.ModelBlackTest(lost);
		
		service.action(lost);
		return AutoAlertProcess.alertAfterRedirect(model,"등록완료","등록되었습니다.","../lost");
	}
}
