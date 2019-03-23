package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.LostDTO;

@Repository
public class LostRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	private String namespace = "losts";

	//분실물 등록
	public void insert(LostDTO lost) {
		sql.insert(namespace+".insert", lost);
		
	}
	//분실물 리스트
	public List<LostDTO> inquiry() {
		
		
		return sql.selectList(namespace+".inquiry");
	}
	//분실물 삭제
	public void delete(int no) {
		
		sql.delete(namespace+".delete",no);
		
	}

}
