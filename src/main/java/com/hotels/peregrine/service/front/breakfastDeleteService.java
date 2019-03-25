package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.BreakfastRepository;

@Service
public class breakfastDeleteService {

	@Autowired
	BreakfastRepository bf;

	public void action(int no) {
		
		bf.delete(no);
		
	}
}
