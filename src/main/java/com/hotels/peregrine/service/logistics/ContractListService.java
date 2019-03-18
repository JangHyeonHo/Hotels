package com.hotels.peregrine.service.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.ContractDTO;
import com.hotels.peregrine.repository.ContractRepository;

@Service
public class ContractListService {
	
	@Autowired
	private ContractRepository repository;

	public List<ContractDTO> contList() {
		// TODO Auto-generated method stub
		return repository.contractList();
	}
}
