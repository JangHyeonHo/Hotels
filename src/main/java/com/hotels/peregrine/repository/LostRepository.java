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

	public void insert(LostDTO lost) {
		sql.insert(namespace+".insert", lost);
		
	}

	public List<LostDTO> inquiry() {
		
		
		return sql.selectList(namespace+".inquiry");
	}

	public void delete(int no) {
		
		sql.delete(namespace+".delete",no);
		
	}

}
