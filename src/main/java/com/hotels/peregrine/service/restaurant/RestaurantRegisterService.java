package com.hotels.peregrine.service.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.RestaurantDTO;
import com.hotels.peregrine.repository.RestaurantRepository;

@Service
public class RestaurantRegisterService {

	@Autowired
	RestaurantRepository repository;
	
	public void action(RestaurantDTO dto) {
		
		repository.rinsert(dto);
		
	}
	
}
