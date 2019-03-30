package com.hotels.peregrine.service.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.PageAndQueryCommand;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.repository.RestaurantRepository;

@Service
public class RestaurantListService {

	@Autowired
	RestaurantRepository repository;
	
	public List<RestaurantReservationDTO> action(AutoPaging paging, PageAndQueryCommand command){
		
		return  repository.reslist(paging, command);
	}

	public int getAllListCount() {
		// TODO Auto-generated method stub
		return repository.getAllListCnt();
	}
}
