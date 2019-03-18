package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.repository.CheckinRepository;
import com.hotels.peregrine.repository.CustomerRepository;

@Service
public class CheckinService {
	
	@Autowired
	private CheckinRepository checkin;

	@Autowired
	private CustomerRepository customer;
	
	public void action(CheckInDTO checkins) {
		CustomerDTO customers = checkins.getCustomer();
		
		customer.insert(customers);
		
		/*checkin.insert(checkins);*/
	}

}
