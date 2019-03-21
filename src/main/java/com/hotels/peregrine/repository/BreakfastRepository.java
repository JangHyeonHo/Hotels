package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BreakfastDTO;

@Repository
public class BreakfastRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "break";

	public void insert(BreakfastDTO breakfast) {
		
		sql.insert("break.insert", breakfast);
		
	}
	
	
}
