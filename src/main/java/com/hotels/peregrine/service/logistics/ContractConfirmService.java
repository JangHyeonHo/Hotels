package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.ContractRepository;

@Service
public class ContractConfirmService {
	
	@Autowired
	private ContractRepository repository;
	
	public boolean isRegist(int no) {
		// TODO Auto-generated method stub
		return repository.isContract(no);
	}
	
}
