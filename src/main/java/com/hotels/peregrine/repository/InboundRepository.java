package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.MaterialInboundDTO;

@Repository
public class InboundRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "inbound";

	public int insertInbound(MaterialInboundDTO dto) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".insertInbound", dto);
	}

	public List<MaterialInboundDTO> selectAllList() {
		// TODO Auto-generated method stub
		return template.selectList(namespace + ".allList");
	}
	
	
}
