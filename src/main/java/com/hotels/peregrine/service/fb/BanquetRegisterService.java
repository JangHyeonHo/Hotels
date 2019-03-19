package com.hotels.peregrine.service.fb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.other.AutoFileClassfication;
import com.hotels.peregrine.other.ClassifiedFile;
import com.hotels.peregrine.repository.BanquetRepository;

@Service
public class BanquetRegisterService {

	@Autowired
	BanquetRepository repository;
	
	
	public void action(BanquetDTO dto) {
		
		
		repository.binsert(dto);
		
	}
	
	
}
