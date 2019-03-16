package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BanquetDTO;

@Repository
public class BanquetRepository {

	@Autowired
	private SqlSessionTemplate template;
	
	// 연회장 등록 
	 public void binsert(BanquetDTO dto) {
		 
		 System.out.println(dto.getBanTime());
		 template.insert("banquet.Binsert",dto);
		 
	 }
}
