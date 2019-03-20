package com.hotels.peregrine.service.lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.LostRepository;

@Service
public class DeleteService {

	@Autowired
	private LostRepository lost;

	public void action(int no) {
		
		lost.delete(no);
	}
	
}
