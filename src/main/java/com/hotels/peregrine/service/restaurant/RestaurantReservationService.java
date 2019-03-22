package com.hotels.peregrine.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.repository.CustomerRepository;
import com.hotels.peregrine.repository.RestaurantRepository;

@Service
public class RestaurantReservationService {

	@Autowired
	private CustomerRepository cusRepository;
	
	@Autowired
	private RestaurantRepository reRepository;
	
	
	public RestaurantReservationDTO cusaction(RestaurantReservationDTO dto) {
		CustomerDTO customers = dto.getCustomer();
		cusRepository.insert(customers);
		dto.getCustomer().setCosNo(cusRepository.select(customers));
		return dto;
	}
	
	
	public List<RestaurantReservationDTO> resname() {
		
		
		
		return	reRepository.resnamesearch();
	}
	
	public void mainaction(RestaurantReservationDTO dto) {
		
		reRepository.resinsert(dto);
	}
}
