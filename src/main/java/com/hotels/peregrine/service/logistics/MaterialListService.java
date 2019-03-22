package com.hotels.peregrine.service.logistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.MaterialCountCommand;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.repository.MaterialRepository;

@Service
public class MaterialListService {
	
	@Autowired
	private MaterialRepository repository;

	public List<MaterialCountCommand> materialList(AutoPaging paging) {
		// TODO Auto-generated method stub
		return repository.getMaterialList(paging);
	}

	public int getAllListCount() {
		// TODO Auto-generated method stub
		return repository.getAllListCnt();
	}
	
	
}
