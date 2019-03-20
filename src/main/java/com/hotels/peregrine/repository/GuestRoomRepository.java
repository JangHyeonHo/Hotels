package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.GuestRoomDTO;

@Repository
public class GuestRoomRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "guestRoom";
	
	

}
