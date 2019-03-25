package com.hotels.peregrine.service.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.repository.FoodRepository;

@Service
public class FoodRegistChangeService {
	
	@Autowired
	private FoodRepository repository;
	
	public String UpdateMenuAndReturn(int no) {
		String ChangeReg = FoodDTO.FOODREGISTKIND[0];
		if(repository.selectManuRegist(no).equals(ChangeReg)){
			ChangeReg = FoodDTO.FOODREGISTKIND[1];
		}
		repository.changeRegist(no, ChangeReg);
		return ChangeReg;
	}
	
}
