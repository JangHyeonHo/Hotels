package com.hotels.peregrine.controller.restaurant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hotels.peregrine.model.RestaurantDTO;
import com.hotels.peregrine.other.AutoFileClassfication;
import com.hotels.peregrine.other.ClassifiedFile;
import com.hotels.peregrine.service.restaurant.RestaurantRegisterService;

@Controller
@RequestMapping("/comp/restaurant/register")
public class RestaurantRegisterController {

	@Autowired
	RestaurantRegisterService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getfrom() {
		System.out.println("레스토랑 등록 오픈");
	
		
		return "restaurant/restaurantRegister";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String postfrom(@ModelAttribute RestaurantDTO dto,@RequestParam("resStoreFileNameOne") MultipartFile file,HttpServletRequest request) {
		System.out.println("레스토랑 포스트 작동 ");
	
		ClassifiedFile storefile = AutoFileClassfication.OnefileClassficationing(file, request.getSession().getServletContext().getRealPath("/") + "RestaurantImage/");
		
		dto.setResStoreFileName(storefile.getFileStoreName());
		
		System.out.println(request.getSession().getServletContext().getRealPath("/") + "RestaurantImage/");
		
		service.action(dto);
		
		return "restaurant/restaurantRegister";
	}
	
}
