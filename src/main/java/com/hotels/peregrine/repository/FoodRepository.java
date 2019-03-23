package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.FoodDTO;

@Repository
public class FoodRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "food";

	public int regist(FoodDTO food) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".registFood", food);
	}

	public int searchNo(FoodDTO food) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".foodNoSelect",food);
	}
	
	
}
