package com.hotels.peregrine.service.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.CheckinCommand;
import com.hotels.peregrine.command.RoomCountCommand;
import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.model.RoomDTO;
import com.hotels.peregrine.repository.BreakfastRepository;
import com.hotels.peregrine.repository.CheckinRepository;
import com.hotels.peregrine.repository.CustomerRepository;
import com.hotels.peregrine.repository.GuestRoomRepository;
import com.hotels.peregrine.repository.RoomRepository;

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
	
	@Autowired
	private RoomRepository room;
	
	public void action(CheckInDTO check, CheckinCommand  command) {
		
		CustomerDTO customers = check.getCustomer();
		GuestRoomDTO guestRoom = new GuestRoomDTO();
		
		if(customers.getCosAllergy()==null || customers.getCosAllergy().equals("") || customers.getCosAllergy().equals("null")) {
			customers.setCosAllergy("N");
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
		

		for(int i = 0; i<command.getGrNo().length; i++) {
			grList.add(new GuestRoomDTO()
					.setGrDiAdult(command.getDinAdult()[i])
					.setGrDiChild(command.getDinChild()[i])
					.setGrNo(command.getGrNo()[i])
					.setGrStaySum(command.getGrStaySum()[i])
					.setCheckIn(new CheckInDTO().setCheNo(checkins.select())));
		}

		
		//수속정보를 바탕으로 객실정보 생성
		guest.insert(grList);

	}

	public List<RoomDTO> nameList() {
		
		return room.nameList();
		
	}

	public RoomCountCommand roomscount(String roomname, String cheIn, String cheOut) {
		
		return room.roomcount(roomname, cheIn, cheOut);
	}

	public List<RoomCountCommand> roomsCount() {
		
		return room.roomCount();
	}
	
	

}
