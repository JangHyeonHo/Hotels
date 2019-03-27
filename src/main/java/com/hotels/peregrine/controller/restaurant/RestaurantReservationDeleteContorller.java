package com.hotels.peregrine.controller.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.service.restaurant.RestaurantReservationDetailService;

@Controller
@RequestMapping("/comp/fb/restaurant/reservation/list/detail/delete")
public class RestaurantReservationDeleteContorller {

	@Autowired
	RestaurantReservationDetailService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getform(@RequestParam("cosno") long no) {
		System.out.println("레스토랑 예약자 삭제 ");
		
		service.deleteaction(no);
		service.deleteactionTwo(no);
		
		return "redirect:../../list";
	}
}
