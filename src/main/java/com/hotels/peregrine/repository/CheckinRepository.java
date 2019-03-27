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

	//체크인(수속) 메소드~
	public void insert(CheckInDTO check) {
		
		sql.insert("checkin.insert", check);
	}
	
	//체크인한 수속번호 검색
	public Integer select() {
		
		
		return  sql.selectOne("checkin.select");
	}

	//수속번호로 체크아웃(cheOutDate 값 삽입)
	public void checkout(int num) {
		 sql.update("checkin.checkout",num);
	
	}

	
}
