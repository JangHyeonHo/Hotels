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
import com.hotels.peregrine.service.front.CheckOutListService;

@Controller
public class CheckOutListController {

	@Autowired
	private CheckOutListService service;
	
	@RequestMapping(value = "/comp/front/checkout", method = RequestMethod.GET)
	public String checkOutList(Model model, @ModelAttribute PageAndQueryCommand command) {
		if(command.getPage() == 0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),8,5);
		paging.setListCount(service.getAllListCount());
		
		List<GuestRoomDTO> list = service.action(paging);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		System.out.println("무엇?몇줄?:"+list.size());
	
		return "front/checkoutlist";
	}	
	
	
}
