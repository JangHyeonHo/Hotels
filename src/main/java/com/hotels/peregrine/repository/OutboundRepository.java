package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.MaterialOutboundDTO;

@Repository
public class OutboundRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "outbound";

	public List<MaterialOutboundDTO> selectAllList() {
		// TODO Auto-generated method stub
		return template.selectList(namespace + ".allList");
	}

}
