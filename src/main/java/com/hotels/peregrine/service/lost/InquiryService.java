package com.hotels.peregrine.service.lost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.LostDTO;
import com.hotels.peregrine.repository.LostRepository;

@Service
public class InquiryService {
	
	@Autowired
	LostRepository lost;

	public List<LostDTO> action() {
		
		return lost.inquiry();
	}

	
}
