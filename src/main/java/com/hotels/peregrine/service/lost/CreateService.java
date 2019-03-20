package com.hotels.peregrine.service.lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.LostDTO;
import com.hotels.peregrine.repository.LostRepository;

@Service
public class CreateService {

	@Autowired
	LostRepository lostrepo;
	
	public void action(LostDTO lost) {
		
		lostrepo.insert(lost);
		
	}

}
