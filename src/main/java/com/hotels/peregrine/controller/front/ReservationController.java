package com.hotels.peregrine.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationController {

	@RequestMapping(value = "/comp/checkin", method = RequestMethod.GET)
	public String reservation() {
		
		
		
		return "front/checkin";
	}
}
