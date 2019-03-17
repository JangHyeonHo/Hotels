package com.hotels.peregrine.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotels.peregrine.model.BanquetDTO;
import com.hotels.peregrine.model.BanquetRentalDTO;

@Repository
public class BanquetRepository {

	@Autowired
	private SqlSessionTemplate template;
	
	// 연회장 등록 
	 public void binsert(BanquetDTO dto) {

		 template.insert("banquet.Binsert",dto);
		 
	 }
	 
	 public void brinsert(BanquetRentalDTO dto) {
		 
		 template.insert("banquet.Brinsert",dto);
	 }
}
