package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.repository.MaterialRepository;

@Service
public class IsMaterialService {
	
	@Autowired
	private MaterialRepository repository;

	public MaterialDTO isExist(int no) {
		// TODO Auto-generated method stub
		return repository.oneMaterialCall(no);
	}

}
