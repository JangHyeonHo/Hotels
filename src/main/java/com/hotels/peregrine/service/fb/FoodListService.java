package com.hotels.peregrine.service.fb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.repository.FoodRepository;

@Service
public class FoodListService {
	
	@Autowired
	private FoodRepository repository;
	
	
	public List<FoodDTO> foodListCall(AutoPaging paging, String kind){
		return repository.listSelect(paging, kind);
	}

	public int getAllListCount() {
		// TODO Auto-generated method stub
		return repository.listCount();
	}

	public FoodDTO foodNamePriceCall(int foodNo) {
		// TODO Auto-generated method stub
		return repository.orderFoodCall(foodNo);
	}
	
}
