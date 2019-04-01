package com.hotels.peregrine.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotels.peregrine.command.LoginCommand;
import com.hotels.peregrine.model.EmployeeDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.service.member.SearchAMemberService;

@Controller
public class LoginController {
	
	@Autowired
	private SearchAMemberService loginService;
	
	@RequestMapping(value = "/comp/member/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("loginfo")!=null) {
			return "redirect:../../comp";
		}
		return "member/login";
	}
	
	@RequestMapping(value = "/comp/member/login", method = RequestMethod.POST)
	public String loginSessionInput(Model model, HttpSession session, HttpServletRequest request,@ModelAttribute LoginCommand command) {
		
			EmployeeDTO dto = loginService.isExist(command);
			if(dto==null) {
				return AutoAlertProcess.alertAfterRedirect(model, "로그인 실패", "이름 혹은 사원번호가 올바르지 않습니다.", "./login");
			}
			session.setAttribute("loginfo", dto);
		
		return "redirect:../../comp";
	}
	
	
	
}
