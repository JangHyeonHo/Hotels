package com.hotels.peregrine.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeFoodRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "recipe";

	public int insertRecipe(int foodNo, int[] materialNo) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> keying = new HashMap<String, Integer>();
		keying.put("foodNo", foodNo);
		int result = 0;
		for(int i : materialNo) {
			keying.put("matNo", i);
			result += template.insert(namespace + ".insertRecipe",keying);
		}
		
		return result;
	}

}
