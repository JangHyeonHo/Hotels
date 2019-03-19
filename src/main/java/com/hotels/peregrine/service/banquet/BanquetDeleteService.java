package com.hotels.peregrine.service.banquet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.BanquetRepository;

@Service
public class BanquetDeleteService {

	@Autowired
	BanquetRepository repository;
	
	
	 public void action(long num) {
		 
		 repository.bdelete(num);
		 
	 }
}
