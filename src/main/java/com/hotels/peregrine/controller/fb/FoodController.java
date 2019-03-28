package com.hotels.peregrine.controller.fb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.command.FoodRegistCommand;
import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.service.fb.FoodDeleteService;
import com.hotels.peregrine.service.fb.FoodListService;
import com.hotels.peregrine.service.fb.FoodRegistChangeService;
import com.hotels.peregrine.service.fb.FoodRegistService;
import com.hotels.peregrine.service.fb.SearchAMaterialService;

@Controller
public class FoodController {
	
	@Autowired
	private SearchAMaterialService searchMatService;
	
	@Autowired
	private FoodRegistService registService;
	
	@Autowired
	private FoodListService listService;
	
	@Autowired
	private FoodRegistChangeService changeService;
	
	@Autowired
	private FoodDeleteService deleteService;
	
	@RequestMapping(value="/comp/fb/restaurant/food/regist", method=RequestMethod.GET)
	public String foodRegistOpenController() {
		
		return "fb/food/foodRegist";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food/searchMaterial", method=RequestMethod.GET)
	public String searchMaterial(Model model) {
		List<MaterialDTO> list = searchMatService.getqueryList("");
		model.addAttribute("list",list);
		return "fb/food/searchWindow";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food/searchMaterial", method=RequestMethod.POST)
	public String resultList(Model model, @RequestParam("query") String query) {
		List<MaterialDTO> list = searchMatService.getqueryList(query);
		if(query=="" || query==null) {
			list = null;
		}
		model.addAttribute("list",list);
		return "fb/food/resultList";
	}
	@RequestMapping(value="/comp/fb/restaurant/food/regist", method=RequestMethod.POST)
	public String registFood(Model model, @ModelAttribute FoodRegistCommand command, HttpServletRequest request) {
		int result = registService.registFood(command, request);
		if(result==0) {
			return AutoAlertProcess.alertAfterRedirect(model, "등록 실패", "등록되지 않았습니다.", "../food");
		}
		return AutoAlertProcess.alertAfterRedirect(model, "음식 등록 완료", "음식이 성공적으로 등록되었습니다.", "../food");
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food", method=RequestMethod.GET)
	public String foodList(Model model, @ModelAttribute PageAndQueryCommand command) {
		if(command.getPage()==0) {
			command.setPage(1);
		}
		AutoPaging paging = new AutoPaging(command.getPage(),15,10);
		paging.setListCount(listService.getAllListCount());
		List<FoodDTO> list = listService.foodListCall(paging,null,null);
		model.addAttribute("directory","/img/fb/food/");
		model.addAttribute("foodList", list);
		model.addAttribute("paging", paging);
		return "fb/food/foodList";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food/change", method=RequestMethod.GET)
	public ResponseEntity<String> MenuChange(@RequestParam("foodNo") int no) {
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(changeService.UpdateMenuAndReturn(no), responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food/delete", method=RequestMethod.GET)
	public String deleteManu(@RequestParam("foodNo") int no, Model model) {
		int result = deleteService.delete(no);
		if(result==0) {
			 return AutoAlertProcess.alertAfterRedirect(model, "삭제 실패", "선택하신 음식은 삭제되지 않았습니다.", "../food");
		}
        return AutoAlertProcess.alertAfterRedirect(model, "삭제 성공", "해당 음식이 성공적으로 삭제되었습니다", "../food");
	}
	
}
