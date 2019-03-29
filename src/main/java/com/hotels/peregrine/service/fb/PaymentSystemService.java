package com.hotels.peregrine.service.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.CardPayDTO;
import com.hotels.peregrine.repository.CartPayRepository;
import com.hotels.peregrine.repository.OrderRepository;
import com.hotels.peregrine.repository.PaymentRepository;

@Service
public class PaymentSystemService {
	
	@Autowired
	private OrderRepository orders;
	
	@Autowired
	private PaymentRepository payment;
	
	@Autowired
	private CartPayRepository card;

	public int updateAllPrice(int table,int price) {
		// TODO Auto-generated method stub
		return orders.allPriceSet(table,price);
	}

	public int cardPay(CardPayDTO command) {
		// TODO Auto-generated method stub
		int result = payment.payment(command.getPayment());
		
		if(result!=0) {
			command.getPayment().setPayNo(0);
			return card.payment(command);
		}
		return 0;
	}

	public String payNumCall(CardPayDTO command) {
		// TODO Auto-generated method stub
		return payment.getPayNo(command.getPayment());
	}

	public int orderPayEnded(int tableNum, int payNo) {
		// TODO Auto-generated method stub
		return orders.updatePayNo(tableNum, payNo);
	}

}
