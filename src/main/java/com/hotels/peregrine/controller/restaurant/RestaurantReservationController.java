package com.hotels.peregrine.controller.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.restaurant.RestaurantReservationService;

@Controller

public class RestaurantReservationController {
	
	@Autowired
	RestaurantReservationService service;

	@RequestMapping(value="/comp/restaurant/reservation/cusinfo",method=RequestMethod.GET)
	public String getformOne() {
		System.out.println("레스토랑 예약 고객정보 오픈");
		
		return "restaurant/restaurantReservationCusInfo";
	}
	
	@RequestMapping(value="/comp/restaurant/reservation/cusinfo",method=RequestMethod.POST)
	public String postformOne(@ModelAttribute RestaurantReservationDTO dto) {
		System.out.println("레스토랑 예약 고객정보 포스트 작동");
		service.cusaction(dto);
			
		return "redirect:../reservation";
	}
	
	
	
	@RequestMapping(value="/comp/restaurant/reservation",method=RequestMethod.GET)
	public String getformTow(@ModelAttribute RestaurantReservationDTO dto , Model model) {
		System.out.println("뭔가 오픈");
		RestaurantReservationDTO cosone = service.reseraction();
		List<RestaurantReservationDTO> resinfo = service.resname();
		model.addAttribute("cosone",cosone);
		model.addAttribute("resinfo",resinfo);
		return "restaurant/restaurantReservation";
	}
	
	@RequestMapping(value="/comp/restaurant/reservation",method=RequestMethod.POST)
	public String postform(@ModelAttribute RestaurantReservationDTO dto ) {
		System.out.println("레스토랑 예약 작동");
		AutoTest.ModelBlackTest(dto);
		service.mainaction(dto);
		
		return "..";
	}
	
}
