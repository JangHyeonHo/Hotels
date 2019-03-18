package com.hotels.peregrine.service.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.repository.MaterialRepository;

@Service
public class MaterialListService {
	
	@Autowired
	private MaterialRepository repository;

	public List<MaterialDTO> materialList() {
		// TODO Auto-generated method stub
		return repository.getMaterialList();
	}
	
	
}
