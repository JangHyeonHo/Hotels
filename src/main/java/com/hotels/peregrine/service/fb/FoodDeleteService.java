package com.hotels.peregrine.service.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.FoodRepository;
import com.hotels.peregrine.repository.RecipeFoodRepository;

@Service
public class FoodDeleteService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private RecipeFoodRepository rfRepository;
	
	public int delete(int no) {
		// TODO Auto-generated method stub
		return foodRepository.deleteFood(no);
	}

}
