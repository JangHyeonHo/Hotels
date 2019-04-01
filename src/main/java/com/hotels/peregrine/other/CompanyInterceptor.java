package com.hotels.peregrine.other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author HKEDU
 *
 */
public class CompanyInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("loginfo")!=null) {
			return true;
		} else {
			response.sendRedirect("/peregrine/comp/member/login");
			return false;
		}
	}

	
}
