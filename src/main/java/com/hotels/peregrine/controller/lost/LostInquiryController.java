package com.hotels.peregrine.controller.lost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.model.LostDTO;
import com.hotels.peregrine.service.lost.InquiryService;

@Controller
public class LostInquiryController {

	@Autowired
	InquiryService service ;
	
	@RequestMapping(value = "/comp/lost/inquiry", method = RequestMethod.GET)
	public String inquiry(Model model) {
	
		List<LostDTO> list = service.action();
		model.addAttribute("list", list);
		return "lost/inquiry";
	}
}
