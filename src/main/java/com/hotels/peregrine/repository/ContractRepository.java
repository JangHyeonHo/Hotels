package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.ContractDTO;

@Repository
public class ContractRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "contract";
	
	//해당 유통업체가 이미 계약중인지 확인 계약 중이면 true 계약중이지 않으면 false
	public boolean isContract(int no) {
		// TODO Auto-generated method stub
		ContractDTO dto = template.selectOne(namespace + ".iscontract", no);
		if(dto==null) {
			return false;
		}
		return true;
	}

	

}
