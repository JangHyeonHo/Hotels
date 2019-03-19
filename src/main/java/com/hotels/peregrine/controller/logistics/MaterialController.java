package com.hotels.peregrine.controller.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.logistics.DistributorHasOneService;
import com.hotels.peregrine.service.logistics.MaterialIsContractService;
import com.hotels.peregrine.service.logistics.MaterialListService;
import com.hotels.peregrine.service.logistics.MaterialRegistService;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialListService listService;
	
	@Autowired
	private MaterialIsContractService isContService;
	
	@Autowired
	private DistributorHasOneService hasOneService;
	
	@Autowired
	private MaterialRegistService registService;
	
	@RequestMapping(value="/comp/logistics/material", method=RequestMethod.GET)
	public String materialList(Model model) {
		List<MaterialDTO> list = listService.materialList();
		model.addAttribute("materialList", list);
		return "logistics/material/matList";
	}
	
	@RequestMapping(value="/comp/logistics/material/regist", method=RequestMethod.GET)
	public String materialRegist(Model model, @RequestParam("contNo") int no) {
		Integer disNo = isContService.isContract(no);
		if(disNo==null) {
			return AutoAlertProcess.alertAfterRedirect(model, "등록 실패", "해당 유통업체는 존재하지 않습니다.", "../material");
		} 
		DistributorDTO dto = hasOneService.hasOneComming(disNo);
		model.addAttribute("distributor", dto);
		model.addAttribute("contNo",no);
		return "logistics/material/matRegist";
	}
	
	@RequestMapping(value="/comp/logistics/material/regist", method=RequestMethod.POST)
	public String materialRegistOn(Model model, @ModelAttribute MaterialDTO dto) {
		AutoTest.ModelBlackTest(dto);
		return AutoAlertProcess.alertAfterRedirect(model, "등록 성공", "해당 자재가 성공적으로 등록되었습니다.", "../material");
	}
	
}
