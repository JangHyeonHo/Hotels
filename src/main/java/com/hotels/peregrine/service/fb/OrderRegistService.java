package com.hotels.peregrine.service.fb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.OrderListDTO;
import com.hotels.peregrine.repository.OrderListRepository;
import com.hotels.peregrine.repository.OrderRepository;

@Service
public class OrderRegistService {
	
	@Autowired
	private OrderRepository order;
	
	@Autowired
	private OrderListRepository orderlist;

	public boolean isRegist(int table) {
		// TODO Auto-generated method stub
		return order.isRegist(table);
	}

	public int firstOrderCall(int table) {
		// TODO Auto-generated method stub
		return order.firstOrder(table);
	}

	public List<OrderListDTO> orderInfo(int table) {
		// TODO Auto-generated method stub
		return orderlist.tableInfomation(table);
	}

}
