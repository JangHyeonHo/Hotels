package com.hotels.peregrine.controller.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.service.logistics.ContractConfirmService;

@Controller
public class ContractController {
	
	@Autowired
	private ContractConfirmService confirmService;
	
	@RequestMapping(name="/comp/logistics/contract/regist", method=RequestMethod.GET)
	public String registContract(Model model, @RequestParam("disNo") int no) {
		if(!confirmService.isRegist(no)) {
			return "logistics/contract/contRegist";
		}
		//존재하면 에러(이미 계약중임)
		return null;
	}
}
