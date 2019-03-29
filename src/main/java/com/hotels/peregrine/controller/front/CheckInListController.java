package com.hotels.peregrine.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.service.front.GuestRoomListService;

@Controller
public class CheckInListController {

	@Autowired
	private GuestRoomListService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/comp/front/rooms", method = RequestMethod.GET)
	public String checkinList(Model model,@ModelAttribute PageAndQueryCommand command) {
		if(command.getPage()==0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),8,3);
		paging.setListCount(service.getAllListCount());
		
		List<GuestRoomDTO> list = service.action(paging);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		
		return "front/checkinlist";
	}	
	
	
	
}
