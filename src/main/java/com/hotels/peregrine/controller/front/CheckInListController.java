package com.hotels.peregrine.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.service.front.GuestRoomListService;

@Controller
public class CheckInListController {

	@Autowired
	private GuestRoomListService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/comp/front/rooms", method = RequestMethod.GET)
	public String checkinList(Model model) {
		
		List<GuestRoomDTO> list = service.action();
		model.addAttribute("list",list);
		
		return "front/checkinlist";
	}	
	
	
	
}
