package com.hotels.peregrine.service.fb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.OrderListDTO;
import com.hotels.peregrine.repository.OrderListRepository;

@Service
public class OrderListService {
	
	@Autowired
	private OrderListRepository repository;

	
	
}
