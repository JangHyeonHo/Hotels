package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.RestaurantDTO;

@Repository
public class RestaurantRepository {

	@Autowired
	private SqlSessionTemplate template;
	
	public void rinsert(RestaurantDTO dto) {
		
		template.insert("restaurant.rinsert",dto);
		
	}
	
}
