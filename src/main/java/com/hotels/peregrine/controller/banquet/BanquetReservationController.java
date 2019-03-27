package com.hotels.peregrine.controller.banquet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.banquet.BanquetReservationService;

@Controller
@RequestMapping("/comp/fb/banquet/reservation")
public class BanquetReservationController {

	@Autowired
	BanquetReservationService service;
		

	@RequestMapping(method= RequestMethod.GET)
	public String getform(Model model) {
		System.out.println("연회장 예약 등록 오픈");
		List<String> dto = service.banNameList();
		model.addAttribute("name",dto);
		return "banquet/banquetReservation";
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String postform(@ModelAttribute BanquetRentalDTO dto) {
		System.out.println("연회장 예약 포스트 작동");
		AutoTest.ModelBlackTest(dto);
		service.action(dto);
		
		return "redirect:list";
	}
}
