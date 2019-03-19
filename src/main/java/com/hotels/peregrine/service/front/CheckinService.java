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
	private CheckinRepository checkins;

	@Autowired
	private CustomerRepository custom;
	
	public void action(CheckInDTO check) {
		CustomerDTO customers = check.getCustomer();
		if(customers.getCosAllergy()==null || customers.getCosAllergy() == "") {
			customers.setCosAllergy("null");
		}
		custom.insert(customers);
		checkins.insert(check);
	
	}




}
