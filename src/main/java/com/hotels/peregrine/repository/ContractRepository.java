package com.hotels.peregrine.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.ContractDTO;
import com.hotels.peregrine.model.DistributorDTO;

@Repository
public class ContractRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "contract";
	
	//해당 유통업체가 이미 계약중인지 확인 계약 중이면 true 계약중이지 않으면 false
	public boolean isContract(int no) {
		// TODO Auto-generated method stub
		Integer dto = template.selectOne(namespace + ".iscontract", no);
		if(dto==null) {
			return false;
		}
		return true;
	}
	
	//해당 유통업체가 계약을 맺었을 때 사용
	public int insertContract(ContractDTO command) {
		// TODO Auto-generated method stub
		return template.insert(namespace + ".insertContract", command);
	}
	
	//계약중인 모든 유통업체 표시
	public List<ContractDTO> contractList() {
		// TODO Auto-generated method stub
		return template.selectList(namespace + ".contractList");
	}
	
	//해당 유통업체와의 계약 해지
	public int deleteContract(int no) {
		// TODO Auto-generated method stub
		return template.delete(namespace + ".deleteContract", no);
	}
	
	//해당 계약이 존재하는지
	public Integer isContractContNo(int no) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".iscontractContno", no);
	}

}
