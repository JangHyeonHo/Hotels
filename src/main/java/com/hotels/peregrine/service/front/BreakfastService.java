package com.hotels.peregrine.service.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.GuestRoomDTO;
import com.hotels.peregrine.repository.BreakfastRepository;
import com.hotels.peregrine.repository.GuestRoomRepository;

@Service
public class BreakfastService {

	@Autowired
	BreakfastRepository bf;

	public List<GuestRoomDTO> action() {
		
		return bf.bflist();
	}
	

	
	

}
