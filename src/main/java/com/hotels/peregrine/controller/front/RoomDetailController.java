package com.hotels.peregrine.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.front.RoomDetailService;

@Controller
public class RoomDetailController {

	@Autowired
	private RoomDetailService service;
	

	@RequestMapping(value = "/comp/front/rooms/detail", method = RequestMethod.GET)
	public String roominfo(@ModelAttribute("grNo")int no, Model model) {
		
		GuestRoomDTO groom = service.action(no);
		model.addAttribute("groom", groom);
		
		return "front/roomDetail";
	}
	
	@RequestMapping(value = "/comp/front/rooms/detail", method = RequestMethod.POST)
	public String roominfo(@ModelAttribute GuestRoomDTO groom , Model model, @ModelAttribute("baseGrNo") String baseGrNo) {
		AutoTest.ModelBlackTest(groom);
		System.out.println(baseGrNo);
		service.modify(groom,Integer.parseInt(baseGrNo));
		
		return AutoAlertProcess.alertAfterRedirect(model, "수정완료", "수정되었습니다.", "../rooms");
	}
}
