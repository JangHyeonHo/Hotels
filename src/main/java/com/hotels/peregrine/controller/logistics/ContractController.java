package com.hotels.peregrine.controller.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.service.logistics.ContractListService;

@Controller
public class ContractController {
	
	@Autowired
	private ContractListService service;
	
	@RequestMapping(value="/comp/logistics/contract", method = RequestMethod.GET)
	public String regist(Model model) {
		service.ContractList();
		return "logistics/contract/contractlist";
	}
}
