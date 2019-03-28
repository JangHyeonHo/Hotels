package com.hotels.peregrine.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.command.CheckinCommand;
import com.hotels.peregrine.command.RoomCountCommand;
import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.RoomDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.service.front.CheckinService;

@Controller
public class CheckinController {

	@Autowired
	private CheckinService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/comp/front/checkin", method = RequestMethod.GET)
	public String checkin(Model model) {
		
		List<RoomDTO> list = service.nameList();
		model.addAttribute("list",list);
//		List<RoomCountCommand> command = service.roomsCount();
//		model.addAttribute("command", command);
		return "front/checkin";
	}	
	

	
	@RequestMapping(value = "/comp/front/checkin", method = RequestMethod.POST)
	public String checkin(@ModelAttribute CheckInDTO check, @ModelAttribute CheckinCommand  command, Model model) {
		System.out.println("체크인 post");

		service.action(check, command);
		
		return AutoAlertProcess.alertAfterRedirect(model, "체크인 완료", "체크인 되었습니다.", "../front");
	}	
	
	@RequestMapping(value = "/comp/front/checkin/roomscount", method = RequestMethod.GET)
	public String checkinRoomCount(@RequestParam("roomsname") String roomname, @RequestParam("cheIn") String cheIn, @RequestParam("cheOut") String cheOut, Model model) {
		
		System.out.println(roomname);
		
		model.addAttribute("result",service.roomscount(roomname, cheIn, cheOut).getRoomCount());
		return "front/roomcount";
	}
	
	
	
	
}
