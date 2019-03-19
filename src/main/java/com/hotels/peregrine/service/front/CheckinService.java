package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.repository.CheckinRepository;

@Service
public class CheckinService {
	
	@Autowired
	private CheckinRepository checkins;

	
	
	public void action(CheckInDTO Check) {
		CustomerDTO customers = Check.getCustomer();
		
		checkins.insert(customers);
	
	}




}
