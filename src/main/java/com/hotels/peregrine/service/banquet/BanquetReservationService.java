package com.hotels.peregrine.service.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.repository.BanquetRepository;

@Service
public class BanquetReservationService {

	@Autowired
	BanquetRepository repository;
	
	public void action(BanquetRentalDTO dto) {
	
		repository.brinsert(dto);
		
	}
	
}
