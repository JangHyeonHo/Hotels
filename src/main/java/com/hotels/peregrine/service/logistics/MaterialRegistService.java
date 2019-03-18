package com.hotels.peregrine.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.repository.MaterialRepository;

@Service
public class MaterialRegistService {
	
	@Autowired
	private MaterialRepository repository;
	
	public int registMaterial(MaterialDTO dto) {
		return repository.insertMaterial(dto);
	}
}
