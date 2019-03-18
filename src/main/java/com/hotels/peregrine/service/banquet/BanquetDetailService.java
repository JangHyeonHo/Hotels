package com.hotels.peregrine.service.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.repository.BanquetRepository;

@Service
public class BanquetDetailService {

	@Autowired
	BanquetRepository repository;
	
	
	public BanquetRentalDTO action(long num) {
		
		return repository.Bdetail(num);
	}
	
	public Integer refresh(long num) {
		
		return repository.dateRefresh1(num);
	}
	
	
	public Integer refresh2(long num) {
		
		return repository.dateRefresh2(num);
	}
	
	
}
