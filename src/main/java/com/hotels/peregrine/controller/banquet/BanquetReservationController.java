package com.hotels.peregrine.controller.banquet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comp/fb/banquet/reservation")
public class BanquetReservationController {

	
	@RequestMapping(method= RequestMethod.GET)
	public String getform() {
		System.out.println("연회장 예약 등록 오픈");
		return "banquet/banquetReservation";
	}
}
