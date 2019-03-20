package com.hotels.peregrine.controller.lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.service.lost.DeleteService;

@Controller
public class LostDeleteController {

	@Autowired
	private DeleteService service;
	
	@RequestMapping(value = "/comp/lost/inquiry/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("lostNo")int no, Model model) {
		service.action(no);
		return AutoAlertProcess.alertAfterRedirect(model, "분실물 삭제", "삭제 되었습니다.", "../inquiry");
		
	}
	
	
	
	
	
}
