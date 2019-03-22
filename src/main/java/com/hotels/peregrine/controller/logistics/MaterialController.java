package com.hotels.peregrine.controller.logistics;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.command.MaterialCountCommand;
import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.model.MaterialInboundDTO;
import com.hotels.peregrine.model.MaterialOutboundDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.logistics.DistributorHasOneService;
import com.hotels.peregrine.service.logistics.InOutboundMaterialService;
import com.hotels.peregrine.service.logistics.IsMaterialService;
import com.hotels.peregrine.service.logistics.MaterialDeleteService;
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
	
	@Autowired
	private MaterialDeleteService deleteService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private IsMaterialService isMatService;
	
	@Autowired
	private InOutboundMaterialService boundService;
	
	@RequestMapping(value="/comp/logistics/material", method=RequestMethod.GET)
	public String materialList(Model model, @ModelAttribute PageAndQueryCommand command) {
		if(command.getPage()==0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),50,10);
		paging.setListCount(listService.getAllListCount());
		List<MaterialCountCommand> list = listService.materialList(paging);
		model.addAttribute("materialList", list);
		model.addAttribute("paging", paging);
		return "logistics/material/matList";
	}
	
	@RequestMapping(value="/comp/logistics/material/regist", method=RequestMethod.GET)
	public String materialRegist(Model model, @RequestParam("contNo") int no) {
		Integer disNo = isContService.isContract(no);
		if(disNo==null) {
			return AutoAlertProcess.alertAfterRedirect(model, "등록 실패", "해당 유통업체는 존재하지 않습니다.", "../material");
		} 
		DistributorDTO dto = hasOneService.hasOneComming(disNo);
		int mtlv = Integer.parseInt(messageSource.getMessage("material.lv.val", null, "default text", Locale.KOREA));
		model.addAttribute("distributor", dto);
		model.addAttribute("contNo",no);
		model.addAttribute("materialLv",mtlv);
		return "logistics/material/matRegist";
	}
	
	@RequestMapping(value="/comp/logistics/material/regist", method=RequestMethod.POST)
	public String materialRegistOn(Model model, @ModelAttribute MaterialDTO dto) {
		AutoTest.ModelBlackTest(dto);
		int result = registService.registMaterial(dto);
		if(result==0) {
			return AutoAlertProcess.alertAfterRedirect(model, "등록 실패", "해당 자재가 등록되지 않았습니다.", "../material");
		}
		return AutoAlertProcess.alertAfterRedirect(model, "등록 성공", "해당 자재가 성공적으로 등록되었습니다.", "../material");
	}
	
	@RequestMapping(value="/comp/logistics/material/delete", method=RequestMethod.GET)
	public String materialDelete(Model model, @RequestParam("matNo") int no) {
		int result = deleteService.deleteMaterial(no);
		if(result==0) {
			return AutoAlertProcess.alertAfterRedirect(model, "삭제 실패", "해당 자재가 삭제 되지 않았습니다.", "../material");
		}
		return AutoAlertProcess.alertAfterRedirect(model, "삭제 성공", "해당 자재가 성공적으로 삭제되었습니다.", "../material");
	}
	
	@RequestMapping(value="/comp/logistics/material/inbound", method=RequestMethod.GET)
	public String inboundMaterial(Model model, @RequestParam("matNo") int no) {
		MaterialDTO dto = isMatService.isExist(no);
//		AutoTest.ModelBlackTest(dto);
		if(dto == null) {
			return AutoAlertProcess.alertAfterRedirect(model, "에러", "존재하지 않는 자재입니다.", "../material");
		}
		model.addAttribute("thisbound","in");
		model.addAttribute("table", "miIn");
		model.addAttribute("dto", dto);
		return "logistics/material/inoutBound";
	}
	
	@RequestMapping(value="/comp/logistics/material/inbound", method=RequestMethod.POST)
	public String inbounding(Model model, @ModelAttribute MaterialInboundDTO dto) {
		AutoTest.ModelBlackTest(dto);
		dto.setMiInbDate(new Date());
		int result = boundService.regist(dto);
		if(result==0) {
			return AutoAlertProcess.alertAfterRedirect(model, "입고 등록 실패", "입고 기록이 저장되지 않았습니다.", "../material");
		}
		return AutoAlertProcess.alertAfterRedirect(model, "입고 등록 완료", "입고 기록이 저장되었습니다.", "../material");
	}
	
	@RequestMapping(value="/comp/logistics/material/outbound", method=RequestMethod.GET)
	public String outboundMaterial(Model model, @RequestParam("matNo") int no) {
		MaterialDTO dto = isMatService.isExist(no);
		AutoTest.ModelBlackTest(dto);
		if(dto == null) {
			return AutoAlertProcess.alertAfterRedirect(model, "에러", "존재하지 않는 자재입니다.", "../material");
		}
		model.addAttribute("thisbound","out");
		model.addAttribute("table", "miOut");
		model.addAttribute("dto", dto);
		return "logistics/material/inoutBound";
	}
	
	@RequestMapping(value="/comp/logistics/material/list", method=RequestMethod.GET)
	public String boundListMaterial(Model model, @ModelAttribute("bo") String boundName) {
		if(boundName == null || boundName.equals("")) {
			boundName = "inbound";
		}
		List list = boundService.boundList(boundName);
		if(list != null) {
			if(boundName.equals("inbound")) {
				List<MaterialInboundDTO> bound = list;
				model.addAttribute("boundlist",bound);
				model.addAttribute("bound","in");
			} else {
				List<MaterialOutboundDTO> bound = list;
				model.addAttribute("boundlist",bound);
				model.addAttribute("bound","out");
			}
		} else {
			model.addAttribute("boundlist",null);
		}
		
		return "logistics/material/List";
	}
	
}
