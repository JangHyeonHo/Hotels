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
//		CheckInDTO ch = Breakfast.getGuestRoom().getCheckIn();
		GuestRoomDTO guestRoom =  Breakfast.getGuestRoom();
		
		if(customers.getCosAllergy()==null || customers.getCosAllergy() == "") {
			customers.setCosAllergy("null");
		}
		custom.insert(customers);
		check.getCustomer().setCosNo(custom.select(customers));
		System.out.println(1);
		checkins.insert(check);
		System.out.println(2);
		Breakfast.getGuestRoom().setCheckIn(new CheckInDTO().setCheNo(checkins.select()));
		AutoTest.ModelBlackTest(Breakfast);
		guest.insert(guestRoom);
		System.out.println(3);
		breakf.insert(Breakfast);
		
		
		
		
		
		
		
		
		

		
//		AutoTest.ModelBlackTest(Breakfast);
//		AutoTest.ModelBlackTest(check);
	

		
	}




}
