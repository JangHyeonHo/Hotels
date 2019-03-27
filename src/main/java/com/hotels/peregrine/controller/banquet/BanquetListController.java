package com.hotels.peregrine.controller.banquet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.service.banquet.BanquetListService;

@Controller
@RequestMapping("comp/fb/banquet/list")
public class BanquetListController {

	@Autowired
	BanquetListService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getform(Model model,@ModelAttribute PageAndQueryCommand command) {
		System.out.println("연회장 예약목록 오픈");
		if(command.getPage()==0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),10,10);
		paging.setListCount(service.getAllListCount());
		
		List<BanquetRentalDTO> list = service.action(paging);
		model.addAttribute("list",list);
		return "banquet/banquetList";
	}
}
