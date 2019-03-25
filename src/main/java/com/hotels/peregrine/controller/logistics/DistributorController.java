package com.hotels.peregrine.controller.logistics;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoFileClassfication;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.other.CSVFileUploader;
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
	public String postRegist(@RequestParam("csvFile") MultipartFile file, HttpServletRequest request, Model model) {
		int i = registService.listRegist(CSVFileUploader.csvFileReader(AutoFileClassfication.CSVFiling(file, request.getSession().getServletContext().getRealPath("/") + "/resources/img/csvBackUp/")));
		System.out.println(i + "개의 유통회사 정보 업로드가 완료되었음.");
		if(i == 0) { 
			return AutoAlertProcess.alertAfterRedirect(model, "등록 실패", "유통회사가 등록되지 않았습니다.", "../");
		} else {
			return AutoAlertProcess.alertAfterRedirect(model, "업로드 완료", i + "개의 유통회사가 성공적으로 등록되었습니다.", "../");
		}
		
	}
	
	@RequestMapping(value="/comp/logistics/distributor", method = RequestMethod.GET)
	public String regist(Model model, @ModelAttribute PageAndQueryCommand command) {
		if(command.getPage()==0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),50,10);
		paging.setListCount(listService.listCount());
		AutoTest.ModelBlackTest(paging);
		List<DistributorDTO> disList = listService.ContractList(paging);
		System.out.println("리스트 사이즈 : " + disList.size());
		model.addAttribute("distributorList", disList);
		model.addAttribute("paging", paging);
		return "logistics/distributor/disList";
	}
	
	
}
