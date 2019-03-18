package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CheckInDTO;

@Repository
public class CheckinRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "checkin";
	
	public void insert(CheckInDTO checkins) {
		sql.insert(namespace+".insert",checkins);
	}

}
