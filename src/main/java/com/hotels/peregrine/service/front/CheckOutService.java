package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.repository.CheckinRepository;

@Service
public class CheckOutService {

	@Autowired
	CheckinRepository check;
	
}
