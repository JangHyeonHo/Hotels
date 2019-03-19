package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CustomerDTO;

@Repository
public class CheckinRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "customer";

	//체크인 메소드~
	public void insert(CustomerDTO customers) {
		sql.insert("customer.insert", customers);
		
	}

/*	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "checkin";
	
	public void insert(CheckInDTO checkins) {
		sql.insert(namespace+".insert",checkins);
	}
*/
}
