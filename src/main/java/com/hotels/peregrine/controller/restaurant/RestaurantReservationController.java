package com.hotels.peregrine.controller.restaurant;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.command.RestaurantCommand;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.restaurant.RestaurantReservationService;

@Controller

public class RestaurantReservationController {
	
	@Autowired
	RestaurantReservationService service;

	@RequestMapping(value="/restaurant/reservation/cusinfo",method=RequestMethod.GET)
	public String getformOne() {
		System.out.println("레스토랑 예약 고객정보 오픈");
		
		return "restaurant/restaurantReservationCusInfo";
	}
	
//	@RequestMapping(value="/restaurant/reservation/cusinfo",method=RequestMethod.POST)
//	public String postformOne(@ModelAttribute RestaurantReservationDTO dto,HttpSession session) {
//		System.out.println("레스토랑 예약 고객정보 포스트 작동");
//		
//		session.setAttribute("ses",dto);
//		System.out.println(dto.getCustomer().getCosNo());
//			
//		return "redirect:../reservation";
//	}
	
	
	
	@RequestMapping(value="/restaurant/reservation",method=RequestMethod.GET)
	public String getformTow(@ModelAttribute CustomerDTO dto ,@ModelAttribute RestaurantCommand command,   Model model, HttpSession session) {
		System.out.println("레스토랑 예약 오픈");
		AutoTest.ModelBlackTest(dto);
		session.setAttribute("ses", dto);
		
		List<RestaurantCommand> resinfo = service.resname();
		System.out.println("테이블 수는? "+resinfo.get(0).getResTableCount());
	
		model.addAttribute("resinfo",resinfo);
		return "restaurant/restaurantReservation";
	}
	
	@RequestMapping(value="/restaurant/reservation",method=RequestMethod.POST)
	public String postform(Model model, @ModelAttribute RestaurantReservationDTO dto,  HttpSession session ) {
		System.out.println("레스토랑 예약 작동");
	
		dto.setCustomer((CustomerDTO) session.getAttribute("ses"));
		AutoTest.ModelBlackTest(dto);
		
		dto = service.cusaction(dto);
		if(service.mainaction(dto)) {
			return "redirect:/comp/fb/restaurant/reservation/list";
		} else {
			return AutoAlertProcess.alertAfterRedirect(model, "예약 등록 실패!", "좌석이 모자랍니다. 다른 날을 이용해 주세요", "./reservation/cusinfo");
		}
		
		
	}
	
	@RequestMapping(value="/restaurant/reservation/table",method=RequestMethod.GET)
	public String getformTow(@ModelAttribute("resname") String resname,@RequestParam("datetime") String dateTime, Model model , HttpSession session) {

		System.out.println(resname);
		System.out.println(dateTime);

		model.addAttribute("result",service.resTableSearch(resname,dateTime).getResTableCount());
		
		
		return "restaurant/restaurantTableCount";
	}
	
}
