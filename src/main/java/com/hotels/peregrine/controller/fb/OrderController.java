package com.hotels.peregrine.controller.fb;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotels.peregrine.exception.NotEqualsTableNumException;
import com.hotels.peregrine.exception.NotSessionExistingException;
import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.model.OrderListDTO;
import com.hotels.peregrine.model.OrdersDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.fb.FoodListService;
import com.hotels.peregrine.service.fb.OrderListService;
import com.hotels.peregrine.service.fb.OrderRegistService;
import com.hotels.peregrine.service.fb.TableListService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRegistService registService;
	
	@Autowired
	private FoodListService foodService;
	
	@Autowired
	private OrderListService olService;
	
	@Autowired
	private TableListService tableService;
	
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
	public String TableRegist(Model model, HttpSession session) {
		if(session.getAttribute("sessionOrderList")!=null) {
			session.invalidate();
		}
		List<OrdersDTO> list = tableService.orderAmountCall();
		model.addAttribute("list",list);
		return "fb/order/orderTable";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/regist", method=RequestMethod.GET)
	public String orderRegist(Model model, @RequestParam("table") int table, HttpSession session) {
		System.out.println("테이블 " + table + "번 주문");
		if(!registService.isRegist(table)) {
			System.out.println("테이블이 존재하지 않으므로 새로 테이블을 등록합니다.");
			registService.firstOrderCall(table);
		} 
		System.out.println("주문페이지 준비하겠습니다.");
		List<OrderListDTO> orders;
		if(session.getAttribute("sessionOrderList")==null) {
			System.out.println("세션에 리스트가 존재하지 않음");
			orders = registService.orderInfo(table);
		}else{
			System.out.println("세션에서 리스트 불러옴");
			orders = (List<OrderListDTO>) session.getAttribute("sessionOrderList");
			if(orders.get(0).getOrders().getOrdTableNum()!=table){
				orders = null;
				orders = registService.orderInfo(table);
			}
		}
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
	
	@RequestMapping(value="/comp/fb/restaurant/order/regist", method=RequestMethod.POST)
	public String orderCall(@RequestParam("tableNo") int tableNo, HttpSession session) throws Exception {
		List<OrderListDTO> olList;
		if(session.getAttribute("sessionOrderList")==null) {
			throw new NotSessionExistingException();
		}else{
			System.out.println("세션에서 리스트 불러옴");
			olList = (List<OrderListDTO>) session.getAttribute("sessionOrderList");
			if(olList.get(0).getOrders().getOrdTableNum()!=tableNo){
				throw new NotEqualsTableNumException();
			}
		}
		registService.orderRegist(olList);
		return "dummy";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/regist/sesinput", method=RequestMethod.POST)
	public String sessionOrdering(Model model, @RequestParam("foodNo") int foodNo, @RequestParam("tableNo") int tableNo, HttpSession session) {
		List<OrderListDTO> olList;
		if(session.getAttribute("sessionOrderList")==null) {
			System.out.println("세션에 리스트가 존재하지 않음");
			olList = registService.orderInfo(tableNo);
		}else{
			System.out.println("세션에서 리스트 불러옴");
			olList = (List<OrderListDTO>) session.getAttribute("sessionOrderList");
			if(olList.get(0).getOrders().getOrdTableNum()!=tableNo){
				olList = registService.orderInfo(tableNo);
			}
		}
		boolean isOverLaping = false;
		for(OrderListDTO dto : olList) {
			if(dto.getFood().getFoodNo()==foodNo) {
				System.out.println("세션에서 불러와서 하나 더함");
				dto.setOlCount(dto.getOlCount()+1);
				isOverLaping = true;
				break;
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
		int allSum = 0;
		for(OrderListDTO dto : olList) {
			allSum += (dto.getFood().getFoodPrice() * dto.getOlCount());
		}
//		AutoTest.ModelBlackTest(olList.get(0));
		session.setAttribute("sessionOrderList", olList);
		model.addAttribute("amount", allSum);
		System.out.println("섹션 객체 저장 완료");
		return "fb/order/orderFoodList";
	}
	
}
