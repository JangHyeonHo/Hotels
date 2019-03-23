package com.hotels.peregrine.service.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.repository.GuestRoomRepository;

@Service
public class GuestRoomListService {
	
	@Autowired
	GuestRoomRepository roomlist;
	
	

	public List<GuestRoomDTO> action() {
		
		return roomlist.roomlist();
	}
	
	

}
