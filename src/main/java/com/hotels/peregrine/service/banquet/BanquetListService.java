package com.hotels.peregrine.service.banquet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.BanquetRentalDTO;
import com.hotels.peregrine.other.AutoPaging;
import com.hotels.peregrine.repository.BanquetRepository;

@Service
public class BanquetListService {

	@Autowired
	BanquetRepository repository;
	
	public List<BanquetRentalDTO> action(AutoPaging paging){
		
		
		return repository.banquetList(paging);
	}

	public int getAllListCount() {
		// TODO Auto-generated method stub
		return repository.getAllListCnt();
	}
}
