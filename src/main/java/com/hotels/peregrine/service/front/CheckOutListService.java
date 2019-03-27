package com.hotels.peregrine.service.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.repository.BreakfastRepository;

@Service
public class CheckOutListService {

	@Autowired
	BreakfastRepository checkout;
	
	public List<GuestRoomDTO> action() {
		
		return checkout.checkoutlist();
	}

}
