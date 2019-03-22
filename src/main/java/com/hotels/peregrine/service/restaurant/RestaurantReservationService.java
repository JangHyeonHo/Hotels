package com.hotels.peregrine.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.repository.RestaurantRepository;

@Service
public class RestaurantReservationService {

	@Autowired
	RestaurantRepository repository;
	
	
	public void cusaction(RestaurantReservationDTO dto) {
		
		repository.resercusinsert(dto);
		
	}
	
	
	public List<RestaurantReservationDTO> resname() {
		
		
		
		return	repository.resnamesearch();
	}
	
	public void mainaction(RestaurantReservationDTO dto) {
		
		 repository.resinsert(dto);
	}
}
