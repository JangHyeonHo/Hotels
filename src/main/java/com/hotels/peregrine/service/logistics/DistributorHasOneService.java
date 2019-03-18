package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.repository.DistributorRepository;

@Service
public class DistributorHasOneService {
	
	@Autowired
	private DistributorRepository repository;
	
	
	public DistributorDTO hasOneComming(int no) {
		
		return repository.disOne(no);
	}
}
