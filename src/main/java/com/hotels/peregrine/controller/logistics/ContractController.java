package com.hotels.peregrine.controller.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.model.ContractDTO;
import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.logistics.ContractConfirmService;
import com.hotels.peregrine.service.logistics.ContractDeleteService;
import com.hotels.peregrine.service.logistics.ContractListService;
import com.hotels.peregrine.service.logistics.ContractRegistService;
import com.hotels.peregrine.service.logistics.DistributorHasOneService;

@Controller
public class ContractController {
	
	@Autowired
	private ContractConfirmService confirmService;
	
	@Autowired
	private DistributorHasOneService hasOneService;
	
	@Autowired
	private ContractRegistService registService;
	
	@Autowired
	private ContractListService listService;
	
	@Autowired
	private ContractDeleteService deleteService;
	
	@RequestMapping(value="/comp/logistics/contract", method=RequestMethod.GET)
	public String listContract(Model model) {
		List<ContractDTO> dto = listService.contList();
		model.addAttribute("ContractList",dto);
		return "logistics/contract/contList";
	}
	
	@RequestMapping(value="/comp/logistics/contract/regist", method=RequestMethod.GET)
	public String registContract(Model model, @RequestParam("disNo") int no) {
		if(!confirmService.isRegist(no)) {
			DistributorDTO dto = hasOneService.hasOneComming(no);
			if(dto!=null) {
				AutoTest.ModelBlackTest(dto);
				model.addAttribute("distributor",dto);
				return "logistics/contract/contRegist";
			}
		}
		//존재하면 에러(이미 계약중임)
		return AutoAlertProcess.alertAfterRedirect(model, "계약중인 데이터", "해당 유통업체가 존재하지 않거나 이미 계약중입니다.", "../distributor");
	}
	
	@RequestMapping(value="/comp/logistics/contract/regist", method=RequestMethod.POST)
	public String registContractTwo(@ModelAttribute ContractDTO command, Model model) {
		AutoTest.ModelBlackTest(command);
		int insert = registService.contractRegist(command);
		if(insert==0) {
			return AutoAlertProcess.alertAfterRedirect(model, "계약 실패", "계약을 다시 시도해 주시기 바랍니다.", "../distributor");
		}
		System.out.println("계약 완료");
		return AutoAlertProcess.alertAfterRedirect(model, "계약 완료", "해당 유통업체와의 계약이 성공적으로 끝났습니다.", "../distributor");
	}
	
	@RequestMapping(value="/comp/logistics/termination", method=RequestMethod.GET)
	public String deleteContract(Model model, @RequestParam("contNo") int no){
		int delete = deleteService.contractDelete(no);
		if(delete==0) {
			return AutoAlertProcess.alertAfterRedirect(model, "해지 실패", "해지를 다시 시도해 주시기 바랍니다.", "./contract");
		}
		return AutoAlertProcess.alertAfterRedirect(model, "계약 해지 완료", "해당 유통업체와의 계약이 성공적으로 해지하였습니다.", "./contract");
	}
	
}
