package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.repository.GuestRoomRepository;

@Service
public class RoomDetailService {
	
	@Autowired
	GuestRoomRepository gr;

	public GuestRoomDTO action(int no) {
		
		return gr.roomdetail(no);
	}

	public void modify(GuestRoomDTO groom, int baseGrNo) {
		
		gr.update(groom, baseGrNo);
		
	}
	
	

}
