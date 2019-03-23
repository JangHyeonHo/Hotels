package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BreakfastDTO;
import com.hotels.peregrine.model.GuestRoomDTO;

@Repository
public class BreakfastRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "break";

	//조식 리스트
	public List<GuestRoomDTO> bflist() {
		
		return sql.selectList("break.bflist");
	}
	
	//고객정보 등록 메소드
	public void insert(BreakfastDTO breakfast) {
		
		sql.insert("break.insert", breakfast);
		
	}

	
	
}
