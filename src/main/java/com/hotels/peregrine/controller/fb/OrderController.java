package com.hotels.peregrine.controller.fb;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.model.OrderListDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.fb.FoodListService;
import com.hotels.peregrine.service.fb.OrderListService;
import com.hotels.peregrine.service.fb.OrderRegistService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRegistService registService;
	
	@Autowired
	private FoodListService foodService;
	
	@Autowired
	private OrderListService olService;
	
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
	
	@RequestMapping(value="/comp/fb/restaurant/order/regist", method=RequestMethod.GET)
	public String orderRegist(Model model, @RequestParam("table") int table) {
		System.out.println("테이블 " + table + "번 주문");
		if(!registService.isRegist(table)) {
			System.out.println("테이블이 존재하지 않으므로 새로 테이블을 등록합니다.");
			registService.firstOrderCall(table);
		} 
		System.out.println("주문페이지 준비하겠습니다.");
		List<OrderListDTO> orders = registService.orderInfo(table);
		AutoTest.ModelBlackTest(orders.get(0));
		int allSum = 0;
		for(OrderListDTO dto : orders) {
			allSum += (dto.getFood().getFoodPrice() * dto.getOlCount());
		}
		AutoPaging page = new AutoPaging(1, 16, 3);
		List<FoodDTO> foodList = foodService.foodListCall(page,"한식");
		model.addAttribute("orderList",orders);
		model.addAttribute("amount", allSum);
		model.addAttribute("foodList",foodList);

		return "fb/order/orderPage";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/regist/sesinput", method=RequestMethod.POST)
	public String sessionOrdering(@RequestParam("foodNo") int foodNo, @RequestParam("tableNo") int tableNo, HttpSession session) {
		List<OrderListDTO> olList;
		if(session.getAttribute("sessionOrderList")==null) {
			olList = olService.getAllolList(tableNo);
		}else{
			olList = (List<OrderListDTO>) session.getAttribute("sessionOrderList");
		}
		boolean isOverLaping = false;
		for(OrderListDTO dto : olList) {
			if(dto.getFood().getFoodNo()==foodNo) {
				dto.setOlCount(dto.getOlCount()+1);
				isOverLaping = true;
			} 
		}
		if(!isOverLaping) {
			if(olList.get(0).getFood().getFoodNo()==0) {
				olList.get(0).setFood(foodService.foodNamePriceCall(foodNo)).setOlCount(1);
			} else {
				olList.add(new OrderListDTO()
						.setOlCount(1)
						.setOrders(olList.get(0).getOrders())
						.setFood(foodService.foodNamePriceCall(foodNo)));
			}
		}
//		AutoTest.ModelBlackTest(olList.get(0));
		session.setAttribute("sessionOrderList", olList);
		System.out.println("섹션 객체 저장 완료");
		return "fb/order/orderFoodList";
	}
	
}
