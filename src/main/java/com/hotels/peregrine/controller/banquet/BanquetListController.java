package com.hotels.peregrine.controller.banquet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.service.banquet.BanquetListService;

@Controller
@RequestMapping("comp/fb/banquet/list")
public class BanquetListController {

	@Autowired
	BanquetListService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getform(Model model) {
		System.out.println("연회장 예약목록 오픈");
		List<BanquetRentalDTO> list = service.action();
		model.addAttribute("list",list);
		return "banquet/banquetList";
	}
}
