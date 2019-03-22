package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.GuestRoomDTO;

@Repository
public class GuestRoomRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "guest";

	public int insert(List<GuestRoomDTO> grList) {
		int result = 0 ;
		for(GuestRoomDTO groom : grList) {
			result++ ;
			sql.insert("guest.insert", groom);
		}
		
		return result;
	}

	public List<GuestRoomDTO> roomlist() {
		
		return sql.selectList("guest.roomlist");
	}
}
