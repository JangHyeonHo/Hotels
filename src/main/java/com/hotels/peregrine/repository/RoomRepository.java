package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.RoomDTO;

@Repository
public class RoomRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "room";
	
	//객실을 만들기위해 있는 메소드~
	public void insert(RoomDTO rooms) {
		sql.insert(namespace+".insert",rooms);
	}

	
	
}
