package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.CheckinCommend;
import com.hotels.peregrine.model.BreakfastDTO;
import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.repository.BreakfastRepository;
import com.hotels.peregrine.repository.CheckinRepository;
import com.hotels.peregrine.repository.CustomerRepository;
import com.hotels.peregrine.repository.GuestRoomRepository;

@Service
public class CheckinService {
	
	@Autowired
	private CheckinRepository checkins;

	@Autowired
	private CustomerRepository custom;
	
	@Autowired
	private BreakfastRepository breakf;
	
	@Autowired
	private GuestRoomRepository guest;
	
	public void action(CheckInDTO check, BreakfastDTO Breakfast) {
		
		CustomerDTO customers = check.getCustomer();
		GuestRoomDTO gues = new GuestRoomDTO();
		GuestRoomDTO guestRoom =  Breakfast.getGuestRoom();
		
		
		if(customers.getCosAllergy()==null || customers.getCosAllergy() == "") {
			customers.setCosAllergy("null");
		}
		custom.insert(customers);
		AutoTest.ModelBlackTest(check);
		check.getCustomer().setCosNo(custom.select(customers));

		checkins.insert(check);
		
		guestRoom.getCheckIn().setCheNo(checkins.select(check));
		
		
		guest.insert(guestRoom);
		
		
		
//
//		breakf.insert(Breakfast);
//		AutoTest.ModelBlackTest(Breakfast);
//		AutoTest.ModelBlackTest(check);
	

		
	}




}
