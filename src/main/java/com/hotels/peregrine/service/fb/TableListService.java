package com.hotels.peregrine.service.fb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.OrdersDTO;
import com.hotels.peregrine.repository.OrderRepository;

@Service
public class TableListService {
	
	@Autowired
	private OrderRepository orders;

	public List<OrdersDTO> orderAmountCall() {
		// TODO Auto-generated method stub
		return orders.amountCall();
	}
	
	
}
