package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.BreakfastDTO;
import com.hotels.peregrine.repository.BreakfastRepository;

@Service
public class BreakfastDetailService {
	
	@Autowired
	BreakfastRepository br;

	public BreakfastDTO action(int no) {
		
		
		return br.bfDetail(no);
	}

	public void create(BreakfastDTO bf) {
		
		br.create(bf);
	}

}
