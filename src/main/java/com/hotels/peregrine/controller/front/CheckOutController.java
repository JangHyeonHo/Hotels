package com.hotels.peregrine.controller.front;

import java.util.Date;

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

import com.hotels.peregrine.command.CheckOutTotalSumCommand;
import com.hotels.peregrine.model.CardPayDTO;
import com.hotels.peregrine.model.CashPayDTO;
import com.hotels.peregrine.other.AutoAlertProcess;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.service.fb.PaymentSystemService;
import com.hotels.peregrine.service.front.CheckOutService;

@Controller
public class CheckOutController {

	@Autowired
	private CheckOutService service;
	
	@Autowired
	private PaymentSystemService paymentService;
	
	@RequestMapping(value = "/comp/front/rooms/checkout", method = RequestMethod.GET)
	public String checkout(@ModelAttribute("cheNo")int num, Model model) {
		
		CheckOutTotalSumCommand price = service.checkInInfo(num);
		AutoTest.ModelBlackTest(price);
		model.addAttribute("totalPrice",price);
		
		return "front/Payment"; 
		
	}
	@RequestMapping(value = "/comp/front/rooms/checkout", method = RequestMethod.POST)
	public String payMentEnded(@ModelAttribute("cheNo")int num, @ModelAttribute("pay") int payNo) {
		
		int result = paymentService.checkOutPayEnded(num, payNo);
		result = service.checkout(num);
        return "dummy";
		
	}
	
	@RequestMapping(value = "/comp/front/rooms/checkout/card", method = RequestMethod.GET)
	private String cardPayWindow(Model model, @RequestParam("pay") int pay) {
		model.addAttribute("pay",pay);
		return "fb/order/cardPayment";
	}
	
	@RequestMapping(value="/comp/front/rooms/checkout/cash", method=RequestMethod.GET)
	private String cashPayWindow(Model model, @RequestParam("pay") int pay) {
		model.addAttribute("pay",pay);
		return "fb/order/cashPayment";
	}
	
	@RequestMapping(value="/comp/front/rooms/checkout/card", method=RequestMethod.POST)
	private ResponseEntity<String> cardPayWindow(Model model, @ModelAttribute CardPayDTO command) {
		AutoTest.ModelBlackTest(command);
		command.getPayment().setPayDate(new Date());
		System.out.println(command.getPayment().getPayDate());
		int result = paymentService.cardPay(command);
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		return new ResponseEntity<String>(paymentService.payNumCall(command.getPayment()), responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/comp/front/rooms/checkout/cash", method=RequestMethod.POST)
	private ResponseEntity<String> cashPayWindow(Model model, @ModelAttribute CashPayDTO command) {
		AutoTest.ModelBlackTest(command);
		command.getPayment().setPayDate(new Date());
		if(command.getCashCeoReceipt().equals("undefined")) {
			command.setCashCeoReceipt(null);
		}
		if(command.getCashReceipt().equals("undefined")) {
			command.setCashReceipt(null);
		}
		
		System.out.println(command.getPayment().getPayDate());
		int result = paymentService.cashPay(command);
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		return new ResponseEntity<String>(paymentService.payNumCall(command.getPayment()), responseHeaders, HttpStatus.CREATED);
	}
}
 