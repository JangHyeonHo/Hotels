package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.DistributorDTO;

@Repository
public class DistributorRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "distributor";
	
	//유통업체 리스트 호출
	public List<DistributorDTO> disList() {
		// TODO Auto-generated method stub
		
		return null;
	}
}