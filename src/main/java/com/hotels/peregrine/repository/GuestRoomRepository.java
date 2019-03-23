package com.hotels.peregrine.repository;

import java.util.HashMap;
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

	//고객이 체크인하면서 사용할 객실 등록
	public int insert(List<GuestRoomDTO> grList) {
		int result = 0 ;
		for(GuestRoomDTO groom : grList) {
			result++ ;
			sql.insert("guest.insert", groom);
		}
		
		return result;
	}
	
	//사용중인 객실 리스트
	public List<GuestRoomDTO> roomlist() {
		
		return sql.selectList("guest.roomlist");
	}
	//사용중인 객실중 특정객실 상세보기
	public GuestRoomDTO roomdetail(int no) {
		
		return sql.selectOne(namespace+".roomDetail", no);
	}
	//등록한 객실 정보 수정
	public void update(GuestRoomDTO groom, Integer baseGrNo) {
		HashMap<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("groom", groom);
		mapping.put("baseGrNo", baseGrNo);
		sql.update("guest.update", mapping);
		
	}




}
