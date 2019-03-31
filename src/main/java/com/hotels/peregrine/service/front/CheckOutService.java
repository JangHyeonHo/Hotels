package com.hotels.peregrine.service.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.CheckOutTotalSumCommand;
import com.hotels.peregrine.repository.CheckinRepository;

@Service
public class CheckOutService {

	@Autowired
	private CheckinRepository check;

	public int checkout(int num) {
		
		return check.checkout(num);
	}

	public CheckOutTotalSumCommand checkInInfo(int num) {
		// TODO Auto-generated method stub
		return check.checkOutOneDTO(num);
	}
	
}
