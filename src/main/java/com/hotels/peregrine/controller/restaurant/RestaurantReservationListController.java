package com.hotels.peregrine.controller.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.service.restaurant.RestaurantListService;

@Controller
@RequestMapping("/comp/fb/restaurant/reservation/list")
public class RestaurantReservationListController {
	
	@Autowired
	RestaurantListService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getform(Model model, @ModelAttribute PageAndQueryCommand command ) {
		System.out.println("레스토랑 예약자 명단 오픈");
		if(command.getPage()==0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),10,10);
		paging.setListCount(service.getAllListCount());
		
		List<RestaurantReservationDTO> list = service.action(paging);
		model.addAttribute("list",list);
		model.addAttribute("paging", paging);
		return "restaurant/restaurantReservationList";
	}

}
