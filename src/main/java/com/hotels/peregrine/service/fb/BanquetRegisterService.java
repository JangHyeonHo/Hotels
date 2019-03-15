package com.hotels.peregrine.service.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.repository.BanquetRepository;

@Service
public class BanquetRegisterService {

	@Autowired
	BanquetRepository repository;
	
	
	public void action(BanquetDTO dto) {
		
		repository.binsert(dto);
		
	}
	
	
}
