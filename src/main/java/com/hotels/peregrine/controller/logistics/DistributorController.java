package com.hotels.peregrine.controller.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.service.logistics.DistributorListService;
import com.hotels.peregrine.service.logistics.DistributorRegistService;

@Controller
public class DistributorController {
	
	@Autowired
	private DistributorListService listService;
	
	@Autowired
	private DistributorRegistService registService;
	
	
	@RequestMapping(value="/comp/logistics/distributor/regist", method = RequestMethod.GET)
	public String getRegist() {
		
		return "logistics/distributor/distriRegist";
	}
	@RequestMapping(value="/comp/logistics/distributor/regist", method = RequestMethod.POST)
	public String postRegist(@RequestParam("csvFile") MultipartFile file) {
		registService.listRegist();
		return "redirect:../";
	}
	
	@RequestMapping(value="/comp/logistics/distributor", method = RequestMethod.GET)
	public String regist(Model model) {
		List<DistributorDTO> disList = listService.ContractList();
		model.addAttribute("distributorList", disList);
		return "logistics/distributor/disList";
	}
	
	
}
