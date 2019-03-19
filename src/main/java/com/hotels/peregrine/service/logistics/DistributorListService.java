package com.hotels.peregrine.service.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.repository.DistributorRepository;

@Service
public class DistributorListService {
	
	@Autowired
	private DistributorRepository repository;
	
	public List<DistributorDTO> ContractList(AutoPaging paging) {
		return repository.disList(paging);
	}
	
	public int listCount() {
		// TODO Auto-generated method stub
		return repository.disListCount();
	}
}
