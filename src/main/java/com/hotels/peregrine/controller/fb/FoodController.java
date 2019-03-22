package com.hotels.peregrine.controller.fb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.fb.SearchAMaterialService;

@Controller
public class FoodController {
	
	@Autowired
	private SearchAMaterialService searchMatService;
	
	@RequestMapping(value="/comp/fb/restaurant/food/regist", method=RequestMethod.GET)
	public String foodRegistOpenController() {
		
		return "fb/food/foodRegist";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food/searchMaterial", method=RequestMethod.GET)
	public String searchMaterial() {
		return "fb/food/searchWindow";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/food/searchMaterial", method=RequestMethod.POST)
	public String resultList(Model model, @RequestParam("query") String query) {
		List<MaterialDTO> list = searchMatService.getqueryList(query);
		model.addAttribute("list",list);
		return "fb/food/resultList";
	}
}
