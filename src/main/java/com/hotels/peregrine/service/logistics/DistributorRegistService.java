package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.DistributorRepository;

@Service
public class DistributorRegistService {

	@Autowired
	private DistributorRepository repository;
	
	public int listRegist() {
		return repository.disListRegist();
	}
}
