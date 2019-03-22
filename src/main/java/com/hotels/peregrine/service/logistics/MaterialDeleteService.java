package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.MaterialRepository;

@Service
public class MaterialDeleteService {
	
	@Autowired
	private MaterialRepository repository;

	public int deleteMaterial(int no) {
		// TODO Auto-generated method stub
		return repository.deleteMaterial(no);
	}
	
	
}
