package com.hotels.peregrine.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.DistributorDTO;
import com.hotels.peregrine.other.AutoPaging;

@Repository
public class DistributorRepository {
	
	@Autowired
	private SqlSessionTemplate template;
	
	private String namespace = "distributor";
	
	//유통업체 리스트 호출
	public List<DistributorDTO> disList(AutoPaging page) {
		// TODO Auto-generated method stub
		Integer minNum = ((page.getPage()-1)*page.getLimit())+1;
		Integer maxNum = minNum+page.getLimit()-1;
		HashMap<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("minNum", minNum);
		mapping.put("maxNum", maxNum);
		return template.selectList(namespace + ".disList", mapping);
	}
	
	//유통업체 csv 대량 등록(완)
	public int disListRegist(List<DistributorDTO> list) {
		// TODO Auto-generated method stub
		int result = 0;
		for(DistributorDTO dto : list) {
			result++;
			template.insert(namespace + ".svcRegist", dto);
		}
		return result;
	}
	
	//유통업체 하나만 호출
	public DistributorDTO disOne(int no) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".disOne", no);
	}
	
	//유통업체 총 개수 호출
	public int disListCount() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace + ".countOne");
	}
}
