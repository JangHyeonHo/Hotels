package com.hotels.peregrine.controller.fb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
	
	@RequestMapping(value="/comp/fb/restaurant/order", method=RequestMethod.GET)
	public String OrderMain() {
		System.out.println("주문등록");
		return "fb/order/orderMain";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/list", method=RequestMethod.GET)
	public String OrderList() {
		return null;
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/table", method=RequestMethod.GET)
	public String TableRegist(Model model) {
		return "fb/order/orderTable";
	}
}
