package com.hotels.peregrine.controller.fb;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.exception.NotEqualsTableNumException;
import com.hotels.peregrine.exception.NotSessionExistingException;
import com.hotels.peregrine.exception.aCountIsNothingException;
import com.hotels.peregrine.model.CardPayDTO;
import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.model.OrderListDTO;
import com.hotels.peregrine.model.OrdersDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.fb.FoodListService;
import com.hotels.peregrine.service.fb.OrderListService;
import com.hotels.peregrine.service.fb.OrderRegistService;
import com.hotels.peregrine.service.fb.PaymentSystemService;
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
	
	@Autowired
	private PaymentSystemService paymentService;
	
	@RequestMapping(value="/comp/fb/restaurant/order", method=RequestMethod.GET)
	public String OrderMain() {
		System.out.println("주문등록");
		return "fb/order/orderMain";
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
	public String orderRegist(Model model, @RequestParam("table") int table, @ModelAttribute PageAndQueryCommand command, HttpSession session) {
		if(command.getPage()==0) {
			command.setPage(1);
		}
		if(command.getSearchSet()==null) {
			command.setSearchSet("한식");
		}
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
//		AutoTest.ModelBlackTest(orders.get(0));
		int allSum = 0;
		for(OrderListDTO dto : orders) {
			allSum += (dto.getFood().getFoodPrice() * dto.getOlCount());
		}
		AutoPaging page = new AutoPaging(command.getPage(), 16, 1);
		page.setListCount(foodService.allFoodCount(command.getSearchSet()));
		List<FoodDTO> foodList = foodService.foodListCall(page,command.getSearchSet(),"등록중");
		AutoTest.ModelBlackTest(page);
		model.addAttribute("orderList",orders);
		model.addAttribute("amount", allSum);
		model.addAttribute("foodList",foodList);
		model.addAttribute("paging",page);
		for(int i = 0; i < FoodDTO.ALLFOODKIND.length ; i++) {
			if(command.getSearchSet().equals(FoodDTO.ALLFOODKIND[i])) {
				model.addAttribute("kind",i+1);
			}
		}
		return "fb/order/orderPage";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/regist/kind", method=RequestMethod.GET)
	public String foodListChange(Model model, @RequestParam("table") int table, @ModelAttribute PageAndQueryCommand command, HttpSession session) {
		if(command.getPage()==0) {
			command.setPage(1);
		}
		if(command.getSearchSet()==null) {
			command.setSearchSet("한식");
		}
		AutoPaging page = new AutoPaging(command.getPage(), 16, 1);
		page.setListCount(foodService.allFoodCount(command.getSearchSet()));
		List<FoodDTO> foodList = foodService.foodListCall(page,command.getSearchSet(),"등록중");
		model.addAttribute("foodList",foodList);
		model.addAttribute("paging",page);
		for(int i = 0; i < FoodDTO.ALLFOODKIND.length ; i++) {
			if(command.getSearchSet().equals(FoodDTO.ALLFOODKIND[i])) {
				model.addAttribute("kind",i+1);
			}
		}
		return "fb/order/foodList";
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
	
	@RequestMapping(value="/comp/fb/restaurant/order/plus", method=RequestMethod.GET)
	public String plusMaterial(@RequestParam("tableNo") int tableNo, @RequestParam("index") int index, HttpSession session, Model model) throws Exception {
		List<OrderListDTO> olList;
		if(session.getAttribute("sessionOrderList")==null) {
			olList = registService.orderInfo(tableNo);
		}else{
			System.out.println("세션에서 리스트 불러옴");
			olList = (List<OrderListDTO>) session.getAttribute("sessionOrderList");
			if(olList.get(0).getOrders().getOrdTableNum()!=tableNo){
				olList = registService.orderInfo(tableNo);
			}
		}
		olList.get(index-1).setOlCount(olList.get(index-1).getOlCount()+1);
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
	
	@RequestMapping(value="/comp/fb/restaurant/order/minus", method=RequestMethod.GET)
	public String minusMaterial(@RequestParam("tableNo") int tableNo, @RequestParam("index") int index, HttpSession session, Model model) throws Exception {
		List<OrderListDTO> olList;
		if(session.getAttribute("sessionOrderList")==null) {
			olList = registService.orderInfo(tableNo);
		}else{
			System.out.println("세션에서 리스트 불러옴");
			olList = (List<OrderListDTO>) session.getAttribute("sessionOrderList");
			if(olList.get(0).getOrders().getOrdTableNum()!=tableNo){
				olList = registService.orderInfo(tableNo);
			}
		}
		if(olList.get(index-1).getOlCount()>0) {
			olList.get(index-1).setOlCount(olList.get(index-1).getOlCount()-1);
		} else {
			throw new aCountIsNothingException();
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
	
	@RequestMapping(value="/comp/fb/restaurant/order/list", method=RequestMethod.GET)
	private String tableOrderList(@ModelAttribute("table") int table, Model model) {
		List<OrderListDTO> olList = olService.listCall(table);
		model.addAttribute("list",olList);
		model.addAttribute("tableNum",table);
		return "fb/order/tableOrderList";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/table/payment", method=RequestMethod.GET)
	private String tablePayment(@ModelAttribute("table") int table, Model model) {
		if(!registService.isRegist(table)) {
			System.out.println("주문이 없으므로 결제페이지 띄울 수 없음");
			return AutoAlertProcess.alertAfterRedirect(model, "결제 에러", "해당 테이블에 주문은 존재하지 않습니다.", "../table");
		} 
		List<OrderListDTO> olList =	registService.orderInfo(table);
		int allSum = 0;
		for(OrderListDTO dto : olList) {
			allSum += (dto.getFood().getFoodPrice() * dto.getOlCount());
		}
		if(allSum == 0) {
			return AutoAlertProcess.alertAfterRedirect(model, "결제 에러", "해당 테이블의 주문 내역이 존재하지 않습니다.", "../table");
		}
		int result = paymentService.updateAllPrice(table,allSum);
		if(result == 0) {
			return AutoAlertProcess.alertAfterRedirect(model, "결제 에러", "다시 시도해 주시기 바랍니다.", "../table");
		}
		model.addAttribute("list",olList);
		model.addAttribute("amount", allSum);
		model.addAttribute("tableNum",table);
		return "fb/order/Payment";
	}
	@RequestMapping(value="/comp/fb/restaurant/order/table/payment", method=RequestMethod.POST)
	public String endedPayment(@ModelAttribute("table") int tableNum, @ModelAttribute("pay") int payNo) {
		System.out.println("실행됐나?");
		int result = paymentService.orderPayEnded(tableNum, payNo);
        return "dummy";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/table/payment/card", method=RequestMethod.GET)
	private String cardPayWindow(Model model, @RequestParam("pay") int pay) {
		model.addAttribute("pay",pay);
		return "fb/order/cardPayment";
	}
	
	@RequestMapping(value="/comp/fb/restaurant/order/table/payment/card", method=RequestMethod.POST)
	private ResponseEntity<String> cardPayWindow(Model model, @ModelAttribute CardPayDTO command) {
		AutoTest.ModelBlackTest(command);
		command.getPayment().setPayDate(new Date());
		System.out.println(command.getPayment().getPayDate());
		int result = paymentService.cardPay(command);
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		return new ResponseEntity<String>(paymentService.payNumCall(command), responseHeaders, HttpStatus.CREATED);
	}
	
}
