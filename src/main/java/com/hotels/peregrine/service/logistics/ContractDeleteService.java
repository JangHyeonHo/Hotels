package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.ContractRepository;

@Service
public class ContractDeleteService {
	
	@Autowired
	private ContractRepository repository;

	public int contractDelete(int no) {
		// TODO Auto-generated method stub
		return repository.deleteContract(no);
	}
	
	
}
