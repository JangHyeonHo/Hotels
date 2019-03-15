package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.RoomDTO;
import com.hotels.peregrine.repository.RoomRepository;
 
@Service
public class RoomsService {

	@Autowired
	private RoomRepository room;


	public void action(RoomDTO rooms) {
		
		room.insert(rooms);
		
	}
	
	
}
