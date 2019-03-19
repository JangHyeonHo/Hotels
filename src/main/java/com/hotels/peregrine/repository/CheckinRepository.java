package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.RoomDTO;

@Repository
public class CheckinRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "checkin";

	//체크인 메소드~
	public void insert(CheckInDTO check) {
		
		
		sql.insert("checkin.insert", check);
		
	}


}
