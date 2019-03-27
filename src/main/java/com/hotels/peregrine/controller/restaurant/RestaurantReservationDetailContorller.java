package com.hotels.peregrine.controller.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.service.restaurant.RestaurantReservationDetailService;

@Controller
@RequestMapping("/comp/fb/restaurant/reservation/list/detail")
public class RestaurantReservationDetailContorller {

	@Autowired
	RestaurantReservationDetailService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getform(Model model , @RequestParam("rrno") long num) {
		System.out.println("레스토랑 예약 상세정보 오픈");
		
		List<RestaurantReservationDTO> list= service.action(num);
		
		System.out.println(list.get(0).getRrAdult());
		System.out.println(list.get(0).getRrChild());
		model.addAttribute("list",list);
		
		return "restaurant/restaurantReservationDetail";
	}
	
}
