package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.command.RoomCountCommand;
import com.hotels.peregrine.model.RoomDTO;

@Repository
public class RoomRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "room";
	
	//객실을 만들기위해 있는 메소드~
	public int insert(RoomDTO rooms) {
		return sql.insert(namespace+".insert",rooms);
	}

	public List<RoomDTO> nameList() {
		
		return sql.selectList(namespace + ".nameList");
		
	}
	//수속하고싶은 룸의 룸개수 확인
	public RoomCountCommand roomcount(String roomname, String cheIn, String cheOut) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("roomname", roomname);
		map.put("cheIn", cheIn);
		map.put("cheOut", cheOut);
		
		return sql.selectOne(namespace+".roomCount",map);
	}

	//체크인한 방 찾아서 빈방 개수표시
	public List<RoomCountCommand> roomCount() {

		return sql.selectList(namespace+".roomCount");
	}

	
	
}
