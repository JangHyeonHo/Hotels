package com.hotels.peregrine.controller.front;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = "/comp/front/add", method = RequestMethod.POST)
	public String reservation(@ModelAttribute RoomDTO rooms, Model model, HttpServletRequest request) {
		AutoTest.ModelBlackTest(rooms);
		int result = service.action(rooms, request);
		return AutoAlertProcess.alertAfterRedirect(model, "등록완료", "등록되었습니다.", "../front");
	}
	
}