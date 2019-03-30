package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CashPayDTO;

@Repository
public class CashPayRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "cashPay";

	public int payment(CashPayDTO command) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".insertCash", command);
	}
}
