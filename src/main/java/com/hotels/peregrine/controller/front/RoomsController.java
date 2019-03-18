package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.RoomDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.front.RoomsService;

@Controller
public class RoomsController {
	
	@Autowired
	RoomsService service;
	
	@RequestMapping(value = "/comp/front/add", method = RequestMethod.GET)
	public String reservation() {
		
		return "front/rooms";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String reservation(@ModelAttribute RoomDTO rooms, Model model) {
		AutoTest.ModelBlackTest(rooms);
		service.action(rooms);
		return AutoAlertProcess.alertAfterRedirect(model, "등록완료", "등록되었습니다.", "./front");
	}
	
}