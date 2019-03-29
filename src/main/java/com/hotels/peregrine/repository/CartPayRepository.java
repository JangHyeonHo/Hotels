package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CardPayDTO;

@Repository
public class CartPayRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "cardPay";

	public int payment(CardPayDTO command) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".insertCard", command);
	}

}
