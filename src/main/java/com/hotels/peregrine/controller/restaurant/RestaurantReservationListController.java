package com.hotels.peregrine.controller.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.service.restaurant.RestaurantListService;

@Controller
@RequestMapping("/comp/restaurant/reservation/list")
public class RestaurantReservationListController {
	
	@Autowired
	RestaurantListService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getform(Model model ) {
		System.out.println("레스토랑 예약자 명단 오픈");
		
		List<RestaurantReservationDTO> list = service.action();
		model.addAttribute("list",list);
		
		return "restaurant/restaurantReservationList";
	}

}
