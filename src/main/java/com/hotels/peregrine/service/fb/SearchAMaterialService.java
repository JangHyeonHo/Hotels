package com.hotels.peregrine.service.fb;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.MaterialDTO;
import com.hotels.peregrine.repository.MaterialRepository;

@Service
public class SearchAMaterialService {
	
	@Autowired
	private MaterialRepository repository;
	
	@Autowired
	private MessageSource messageSource;

	public List<MaterialDTO> getqueryList(String query) {
		// TODO Auto-generated method stub
		HashMap<String, String> mapping = new HashMap<String, String>();
		mapping.put("query", "%"+query+"%");
		mapping.put("search", messageSource.getMessage("material.lv1", null, "default text", Locale.KOREA));
		return repository.searchMaterialList(mapping);
	}

}
