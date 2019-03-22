package com.hotels.peregrine.service.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.CheckinCommend;
import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.GuestRoomDTO;
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
	
	public void action(CheckInDTO check, CheckinCommend  command /*, BreakfastDTO Breakfast*/) {
		
		CustomerDTO customers = check.getCustomer();
		GuestRoomDTO guestRoom = new GuestRoomDTO();
		
		if(customers.getCosAllergy()==null || customers.getCosAllergy() == "") {
			customers.setCosAllergy("null");
		}
		System.out.println("sad :"+command.getGrNo().length);
		List<GuestRoomDTO> grList = new ArrayList<GuestRoomDTO>();
		
		
		
		//고객정보 생성
		custom.insert(customers);
		check.getCustomer().setCosNo(custom.select(customers));
		System.out.println(1);
		//고객정보를 바탕으로 수속정보 생성
		checkins.insert(check);
		System.out.println(2);
		
//		guestRoom.setCheckIn(new CheckInDTO().setCheNo(checkins.select()));
		for(int i = 0; i<command.getGrNo().length; i++) {
			grList.add(new GuestRoomDTO()
					.setGrDiAdult(command.getDinAdult()[i])
					.setGrDiChild(command.getDinChild()[i])
					.setGrNo(command.getGrNo()[i])
					.setGrStaySum(command.getGrStaySum()[i])
					.setCheckIn(new CheckInDTO().setCheNo(checkins.select())));
		}
//		Breakfast.getGuestRoom().setCheckIn(new CheckInDTO().setCheNo(checkins.select()));
//		AutoTest.ModelBlackTest(Breakfast);
		
		//수속정보를 바탕으로 객실정보 생성
		guest.insert(grList);
//		System.out.println(3);
//		breakf.insert(Breakfast);
		
		
		
		
		
		
		
		
		

		
//		AutoTest.ModelBlackTest(Breakfast);
//		AutoTest.ModelBlackTest(check);
	

		
	}




}
