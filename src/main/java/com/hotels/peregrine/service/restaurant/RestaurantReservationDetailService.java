package com.hotels.peregrine.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.repository.RestaurantRepository;

@Service
public class RestaurantReservationDetailService {

	@Autowired
	RestaurantRepository repository;
	
	public List<RestaurantReservationDTO> action(long num){
		
		return repository.reserDetail(num); 
	}
	
	public void deleteaction(long no) {
		
		repository.resdelete(no);
		
	}
	
	public void deleteactionTwo(long no) {
		
		repository.resdeleteTwo(no);
	}
}
