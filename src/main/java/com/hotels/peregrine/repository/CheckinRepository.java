package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.CheckInDTO;
import com.hotels.peregrine.model.GuestRoomDTO;

@Repository
public class CheckinRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "checkin";

	//체크인(수속) 메소드~
	public void insert(CheckInDTO check) {
		
		sql.insert("checkin.insert", check);
	}
	
	//체크인한 수속번호 검색
	public Integer select() {
		
		
		return  sql.selectOne("checkin.select");
	}


	
}
