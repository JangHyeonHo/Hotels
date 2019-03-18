package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.ContractDTO;
import com.hotels.peregrine.repository.ContractRepository;

@Service
public class ContractRegistService {
	
	@Autowired
	private ContractRepository repository;

	public int contractRegist(ContractDTO command) {
		// TODO Auto-generated method stub
		return repository.insertContract(command);
	}

}
